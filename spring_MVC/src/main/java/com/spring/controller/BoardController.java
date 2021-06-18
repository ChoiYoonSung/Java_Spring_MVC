package com.spring.controller;

import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.command.BoardModifyCommand;
import com.spring.command.BoardRegistCommand;
import com.spring.command.SearchCriteria;
import com.spring.dto.BoardVO;
import com.spring.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("/main")
	public String main() throws Exception{
		return "board/main";
	}
	
	@RequestMapping("/list")
	public ModelAndView list(SearchCriteria cri, ModelAndView mnv) throws SQLException{
		String url = "board/list";
		Map<String,Object> dataMap = boardService.getBoardList(cri);
		
		mnv.addObject("dataMap",dataMap);
		mnv.setViewName(url);
		
		return mnv;
	}
	
	@RequestMapping("/registForm")
	public String registForm() {
		String url = "board/regist";
		return url;
	}
	
	
	@RequestMapping("/regist")
	public String regist(BoardRegistCommand boardReq, HttpServletRequest request) throws Exception{
		String url = "regist_succes";
		
		BoardVO board = boardReq.toBoardVO();
		board.setTitle((String)request.getAttribute("XSStitle"));
		
		boardService.registBoard(board);
		return url;
	}
	
	
	@RequestMapping("/detail")
	public ModelAndView detail(int bno, @RequestParam(defaultValue="")String from, ModelAndView mnv)
			throws Exception{
		String url = "board/detail";
		BoardVO board = null;
		
		if(from.equals("modify")) {
			board = boardService.getBoardForModify(bno);
		}else {
			board = boardService.getBoard(bno);
		}
		
		mnv.addObject("board",board);
		mnv.setViewName(url);
		
		return mnv;
	}
	
	
	@RequestMapping("/modifyForm")
	public ModelAndView modifyForm(int bno, ModelAndView mnv) throws Exception{
		String url = "board/modify";
		
		BoardVO board = boardService.getBoardForModify(bno);
		
		mnv.addObject("board",board);
		mnv.setViewName(url);
		
		return mnv;
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modifyPost(BoardModifyCommand modifyReq, HttpServletRequest request) throws Exception{
		String url = "redirect:/board/detail.do?from=modify&bno="+request.getParameter("bno");
		
		BoardVO board = modifyReq.toBoardVO();
		board.setTitle((String)request.getAttribute("XSStitle"));
		boardService.modiftyBoard(board);
		
		return url;
	}
}

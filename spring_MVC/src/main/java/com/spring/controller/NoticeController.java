package com.spring.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.command.NoticeModifyCommand;
import com.spring.command.NoticeRegistCommand;
import com.spring.command.SearchCriteria;
import com.spring.dto.NoticeVO;
import com.spring.service.NoticeService;

@Controller
@RequestMapping("/notice")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	
	@RequestMapping("/main")
	public void main() throws Exception{}
	
	
	@RequestMapping("/list")
	public void list(SearchCriteria cri, Model model) throws Exception{
		Map<String, Object> dataMap = noticeService.getNoticeList(cri);
		
		model.addAttribute("dataMap",dataMap);
	}
	
	
	@RequestMapping("/registForm")
	public String registForm() {
		String url = "notice/regist";
		return url;
	}
	
	
	@RequestMapping("/regist")
	public String regist(NoticeRegistCommand noticeReq, HttpServletRequest request) throws Exception{
		String url = "regist_succes";
		
		NoticeVO notice = noticeReq.toNoticeVO();
		notice.setTitle((String)request.getAttribute("XSStitle"));
		
		noticeService.registNotice(notice);
		return url;
	}
	
	
	@RequestMapping("/detail")
	public ModelAndView detail(int nno, @RequestParam(defaultValue="")String from, ModelAndView mnv)
			throws Exception{
		String url = "notice/detail";
		NoticeVO notice = null;
		
		if(from.equals("modify")) {
			notice = noticeService.getNoticeforModify(nno);
		}else {
			notice = noticeService.getNotice(nno);
		}
		
		mnv.addObject("notice",notice);
		mnv.setViewName(url);
		
		return mnv;
	}
	
	@RequestMapping("/modifyForm")
	public ModelAndView modifyForm(int nno, ModelAndView mnv) throws Exception{
		String url = "notice/modify";
		
		NoticeVO notice = noticeService.getNoticeforModify(nno);
		
		mnv.addObject("notice",notice);
		mnv.setViewName(url);
		
		return mnv;
	}
	
	
	@RequestMapping(value="/modify" ,method=RequestMethod.POST)
	public String modifyPost(int nno, NoticeModifyCommand modifyReq, HttpServletRequest request) throws Exception{
		String url = "redirect:/common/from=modify&detail.do?nno="+nno;
		
		NoticeVO notice = modifyReq.toNoticeVO();
		notice.setTitle((String)request.getAttribute("XSStitle"));
		noticeService.modiftyNotice(notice);
		
		return url;
	}
	
	
}

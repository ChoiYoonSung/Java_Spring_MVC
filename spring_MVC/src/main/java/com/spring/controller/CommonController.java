package com.spring.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.command.LoginCommand;
import com.spring.dto.MenuVO;
import com.spring.exception.InvalidPasswordException;
import com.spring.exception.NotFoundException;
import com.spring.service.MemberService;
import com.spring.service.MenuService;

@Controller
public class CommonController {
	@Autowired
	private MemberService memberService;
	@Autowired
	private MenuService menuService;

	@RequestMapping(value = "/common/login", method = RequestMethod.GET)
	public void loginForm() throws Exception {
	}
	// 페이지 경로와 url이 같으면 생략 가능
	// Mapper Adapter

	@RequestMapping(value = "/common/login", method = RequestMethod.POST)
	public String loginPost(LoginCommand loginReq, HttpServletRequest request, HttpServletResponse response,
			RedirectAttributes rttr) throws Exception {
		String url = "redirect:/index.do";

		HttpSession session = request.getSession();
		try {
			memberService.login(loginReq.getId(), loginReq.getPwd());
			session.setAttribute("loginUser", memberService.getMember(loginReq.getId()));
			session.setMaxInactiveInterval(6 * 60);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (NotFoundException | InvalidPasswordException e) {
			url = "redirect:/common/login.do";
			rttr.addFlashAttribute("msg", e.getMessage());
		}

		return url;
	}

	@RequestMapping(value="/common/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "redirect:/";

		HttpSession session = request.getSession();
		session.invalidate();

		return url;
	}

	@RequestMapping("/index")
	public ModelAndView indexPage(ModelAndView mnv, @RequestParam(defaultValue = "M000000") String mCode,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "common/indexPage";

		try {
			List<MenuVO> menuList = menuService.getMainMenuList();
			MenuVO menu = menuService.getMenuByMcode(mCode);

			mnv.addObject("menuList", menuList);
			mnv.addObject("menu", menu);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}

		mnv.setViewName(url);
		return mnv;
	}
	
	@RequestMapping("/getMcode")
	@ResponseBody
// dispatcher -> viewresolver (x)
// 바로 출력하라고 알려주는 Annotation
	public ResponseEntity<MenuVO> getMcode(String mName) throws Exception{
		ResponseEntity<MenuVO> entity = null;
		try {
			MenuVO menu = menuService.getMenuByMname(mName);
			
			entity = new ResponseEntity<MenuVO>(menu, HttpStatus.OK);
		} catch (SQLException e) {
			entity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return entity;
	}

	@RequestMapping("/subMenu")
	@ResponseBody
	public ResponseEntity<List<MenuVO>> subMenu(String mCode) throws Exception{
		ResponseEntity<List<MenuVO>> entity = null;
		try {
			
			List<MenuVO> menuList = menuService.getSubMenuList(mCode);
			
			entity = new ResponseEntity<List<MenuVO>>(menuList, HttpStatus.OK);
		} catch (SQLException e) {
			entity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return entity;
	}
}

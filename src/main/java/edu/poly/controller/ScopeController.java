package edu.poly.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ScopeController {
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	HttpSession session;
	
	@Autowired
	ServletContext servletContext;
	
	@RequestMapping("/scope")
	public String scope(Model model) {
		model.addAttribute("a", "I'm in Model");
		request.setAttribute("b", "I'm in Request Scope");
		session.setAttribute("c", "I'm in Session Scope");
		servletContext.setAttribute("d", "I'm in Application Scope");
		
		return "/scope/index";
	}
}

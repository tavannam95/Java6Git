package edu.poly.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthController {

	@RequestMapping("/home/index2")
	public String index2(
			) {
		return "home/index2";
	}
	
	@RequestMapping("/home/about2")
	public String about2(
			) {
		return "home/about2";
	}
	
	@RequestMapping("/auth/login/form")
	public String formLogin() {
		return "auth/form";
	}
	
	@RequestMapping("/auth/login/success")
	public String loginSuccess(
				Model model
			) {
		model.addAttribute("message", "Đăng nhập thành công!");
		return "forward:/home/index2";
	}
	
	@RequestMapping("/auth/login/error")
	public String loginError(
				Model model
			) {
		model.addAttribute("message", "Sai thông tin đăng nhập!");
		return "forward:/auth/login/form";
	}
	
	@RequestMapping("/auth/logoff/success")
	public String logoffSuccess(
				Model model
			) {
		model.addAttribute("message", "Đăng xuất thành công!");
		return "forward:/auth/login/form";
	}
	
	@RequestMapping("/auth/logoff/error")
	public String logoffEror(
				Model model
			) {
		model.addAttribute("message", "Đăng xuất thất bại!");
		return "forward:/auth/login/form";
	}
	
	@PreAuthorize("hasRole('ADMIN')")
//	@PreAuthorize("isAuthenticated()")
	@RequestMapping("/home/admins")
	public String admin(
				Model model
			) {
		model.addAttribute("message", "Xin chào admin!");
		
		return "/home/index2";
	}
}

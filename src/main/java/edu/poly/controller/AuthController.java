package edu.poly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthController {
	@RequestMapping("/auth/login/form")
	public String formLogin() {
		return "auth/form";
	}
	@RequestMapping("/auth/login/success")
	public String loginSuccess(
				Model model
			) {
		model.addAttribute("message", "Đăng nhập thành công!");
		return "forward:/product/list";
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
		return "forward:/product/list";
	}
	
	@RequestMapping("/auth/logoff/error")
	public String logoffEror(
				Model model
			) {
		model.addAttribute("message", "Đăng xuất thất bại!");
		return "forward:/auth/login/form";
	}
}

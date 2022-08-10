package edu.poly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrderController {

	@RequestMapping("/order/checkout")
	public String checkOut() {
		return "order/checkout";
	}
	@RequestMapping("/order/list")
	public String list() {
		return "order/list";
	}
	@RequestMapping("/order/detail/{id}")
	public String detail() {
		return "order/detail";
	}
	
}

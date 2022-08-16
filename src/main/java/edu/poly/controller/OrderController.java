package edu.poly.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.poly.entities.Order;
import edu.poly.service.OrderService;

@Controller
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@RequestMapping("/order/checkout")
	public String checkOut() {
		return "order/checkout";
	}
	@RequestMapping("/order/list")
	public String list(
				Model model,
				HttpServletRequest request
			) {
		String username = request.getRemoteUser();
		
		List<Order> orders = this.orderService.findByUsername(username);
		
		model.addAttribute("orders", orders);
		
		return "order/list";
	}
	@RequestMapping("/order/detail/{id}")
	public String detail(
			@PathVariable("id") Integer id,
			Model model
			) {
		
		Order order = this.orderService.findById(id).get();
		model.addAttribute("order", order);
		
		return "order/detail";
	}
	
}

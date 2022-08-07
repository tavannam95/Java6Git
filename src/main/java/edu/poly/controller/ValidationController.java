package edu.poly.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import edu.poly.bean.Student3;

@Controller
public class ValidationController {
	
	@ModelAttribute("countries")
	public Map<String, String> getCountry() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("VN", "Việt Nam");
		map.put("US", "United States");
		return map;
	}
	
	@GetMapping("/validation/form")
	public String form(
				Model model
			) {
		Student3 sv = new Student3();
		model.addAttribute("sv", sv);
		return "validation/form";
	}

	@PostMapping("/validation/validate")
	public String save(
				Model model,
				@Validated @ModelAttribute("sv") Student3 student3,
				Errors errors
			) {
		if (errors.hasErrors()) {
			model.addAttribute("message", "Lỗi form!");
			return "validation/form";
		}
		model.addAttribute("message", "Thành công!");
		return "validation/success";
	}
}

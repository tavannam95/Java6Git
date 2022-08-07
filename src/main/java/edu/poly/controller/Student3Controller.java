package edu.poly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.poly.bean.Student3;
import edu.poly.bean.Student3Map;
import edu.poly.dao.Student3DAO;

@Controller
public class Student3Controller {
	
	@Autowired
	Student3DAO student3Dao;
	
	@RequestMapping("/student/index")
	public String index(Model model) {
		Student3 student3 = new Student3("", "", 0.0, true, "VN");
		model.addAttribute("form", student3);
		Student3Map items = this.student3Dao.findAll();
		model.addAttribute("items", items);
		return "student/index";
	}
	
	@RequestMapping("/student/edit/{key}")
	public String edit(
				Model model,
				@PathVariable("key") String key
			) {
		model.addAttribute("key", key);
		Student3 student3 = this.student3Dao.findByKey(key);
		model.addAttribute("form", student3);
		Student3Map map = this.student3Dao.findAll();
		model.addAttribute("items", map);
		return "student/index";
	}
	
	@RequestMapping("/student/create")
	public String crate(Student3 student3) {
		this.student3Dao.create(student3);
		return "redirect:/student/index";
	}
	
	@RequestMapping("/student/update/{key}")
	public String update(
				@PathVariable("key") String key,
				Student3 student3
			) {
		System.out.println(student3.getFullname());
		this.student3Dao.update(key, student3);
		return "redirect:/student/edit/" + key;
	}
	
	@RequestMapping("/student/delete/{key}")
	public String delete(
				@PathVariable("key") String key
			) {
		this.student3Dao.delete(key);
		return "redirect:/student/index";
	}
}

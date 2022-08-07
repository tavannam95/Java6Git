package edu.poly.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.poly.bean.Student2;

@Controller
public class Student2Controller {

	@RequestMapping("/student/list")
	public String list(
				Model model,
				@RequestParam("index") Optional<Integer> index
			) throws IOException{
		
		File file = new ClassPathResource("/students.json").getFile();
		TypeReference<List<Student2>> type = new TypeReference<List<Student2>>() {
		};
		ObjectMapper mapper = new ObjectMapper();
		List<Student2> list = mapper.readValue(file, type);
		
		model.addAttribute("sv", list.get(index.orElse(0)));
		model.addAttribute("listSv", list);
		
		return "student/list";
	}
	
}

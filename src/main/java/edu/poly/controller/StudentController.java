package edu.poly.controller;

import java.io.File;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.poly.bean.Stus;

@Controller
public class StudentController {
	
	@RequestMapping("/student")
	public String student(
				Model model,
				@RequestParam("index") Optional<Integer> index
			) throws Exception {
		
		String path = "C:\\Users\\uhtku\\eclipse-workspace\\Java6\\src\\main\\resources\\stus.json";
		
		ObjectMapper mapper = new ObjectMapper();
		TypeReference<List<Stus>> type = new TypeReference<List<Stus>>() {
		};
		List<Stus> stus = mapper.readValue(new File(path), type);
		
		int i = index.orElse(0);
		model.addAttribute("n", i);
		model.addAttribute("sv", stus.get(i));
		
		return "scope/student";
	}
}

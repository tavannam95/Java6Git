package edu.poly.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.poly.bean.Student2;

@Controller
public class UtilityController {
	
	@RequestMapping("/demo/utilities")
	public String utility(
				Model model
			) throws IOException{
		File file = new ClassPathResource("/students.json").getFile();
		TypeReference<List<Student2>> type = new TypeReference<List<Student2>>() {
		};
		ObjectMapper mapper = new ObjectMapper();
		
		List<Student2> list = mapper.readValue(file, type);
		
		model.addAttribute("dssv", list);
		model.addAttribute("now", new Date());
		
		return "utilities";
	}
}

package edu.poly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import edu.poly.dao.StudentDAO;
import edu.poly.entities.Student;

@CrossOrigin("*")
@RestController
public class StudentRestController {

	@Autowired
	StudentDAO dao;
	
	@GetMapping("/rest/students")
	public List<Student> getAll() {
		return this.dao.findAll();
	}
	
	@GetMapping("/rest/students/{email}")
	public Student findOne(
				@PathVariable("email") String email
			) {
		return dao.findById(email).get();
	}
	
}

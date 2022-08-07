package edu.poly.bean;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student2 {
	String name;
	boolean gender;
	double marks; 
	Contact contact;
	List<String> subjects;
}

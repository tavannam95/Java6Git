package edu.poly.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Stus {
	private String name;
	private boolean gender;
	private double marks; 
	String email;
}
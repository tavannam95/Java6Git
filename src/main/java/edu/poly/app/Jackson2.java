package edu.poly.app;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.poly.bean.Contact;
import edu.poly.bean.Student2;

public class Jackson2 {
	public static void main(String[] args) throws Exception {
		demo7();
	}

	private static void demo7() throws Exception {

		Contact contact = new Contact("namtv123@gmail.com","0968666888", null);
		List<String> subjects = Arrays.asList("WEB203","COM108");
		Student2 student = new Student2("Nam Ta", true, 8.5, contact, subjects);
		
		ObjectMapper mapper = new ObjectMapper();
		//Write to String
		String json = mapper.writeValueAsString(student);
//		System.out.println(">> String: \n" + json);
		//Write to output
		mapper.writerWithDefaultPrettyPrinter().writeValue(System.out, student);
		//Write to file
		mapper.writeValue(new File("C:\\Users\\uhtku\\eclipse-workspace\\Java6\\src\\main\\resources\\templates\\student3.json"), student);
	}

	private static void demo4() throws Exception {

		String path = "C:\\Users\\uhtku\\eclipse-workspace\\Java6\\src\\main\\resources\\students.json";

		ObjectMapper mapper = new ObjectMapper();
		TypeReference<List<Student2>> type = new TypeReference<List<Student2>>() {
		};
		List<Student2> students = mapper.readValue(new File(path), type);
		students.forEach(student ->{
			System.out.println(">> Name: " + student.getName());
		});
	}

	private static void demo3() throws Exception {
		String path = "C:\\Users\\uhtku\\eclipse-workspace\\Java6\\src\\main\\resources\\student.json";

		ObjectMapper mapper = new ObjectMapper();
		Student2 student2 = mapper.readValue(new File(path), Student2.class);
		
		System.out.println(">> Name: " + student2.getName());
		System.out.println(">> Gender: " + student2.isGender());
		System.out.println(">> Marks: " + student2.getMarks());
		Contact contact = student2.getContact();
		System.out.println(">> Phone: " + contact.getPhone());
		System.out.println(">> Phone: " + contact.getEmail());
		List<String> subjects = student2.getSubjects();
		subjects.forEach(subject ->{
			System.out.println(">> Subjects: " + subject);
		});

	}

	private static void demo2() throws Exception {
		String path = "C:\\Users\\uhtku\\eclipse-workspace\\Java6\\src\\main\\resources\\students.json";

		ObjectMapper mapper = new ObjectMapper();
		List<Map<String, Object>> students = mapper.readValue(new File(path), List.class);
		students.forEach(student -> {
			System.out.println(">> Name: " + student.get("name"));
		});

	}

	private static void demo1() throws Exception {

		String path = "C:\\Users\\uhtku\\eclipse-workspace\\Java6\\src\\main\\resources\\student.json";

		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> student = mapper.readValue(new File(path), Map.class);

		System.out.println(">> Name: " + student.get("name"));
		System.out.println(">> Gender: " + student.get("gender"));
		System.out.println(">> Marks: " + student.get("marks"));
		Map<String, Object> contact = (Map<String, Object>) student.get("contact");
		System.out.println(">> Phone: " + contact.get("phone"));
		System.out.println(">> Phone: " + contact.get("email"));
		List<String> subjects = (List<String>) student.get("subjects");

		subjects.forEach(subject -> {
			System.out.println(">> Subjects: " + subject);
		});

	}
}

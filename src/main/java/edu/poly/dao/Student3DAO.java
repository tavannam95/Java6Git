package edu.poly.dao;

import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;

import edu.poly.bean.Student3;
import edu.poly.bean.Student3Map;

@Repository
public class Student3DAO {
	RestTemplate rest = new RestTemplate();
	
	String url = "https://poly-java-6-e1836-default-rtdb.asia-southeast1.firebasedatabase.app/students.json";
	
	private String getURL(String key) {
		return url.replace(".json", "/" + key + ".json");
	}
	
	public Student3Map findAll() {
		return rest.getForObject(url, Student3Map.class);
	}
	
	public Student3 findByKey(String key) {
		return rest.getForObject(getURL(key), Student3.class);
	}
	
	public String create(Student3 data) {
		HttpEntity<Student3> entity = new HttpEntity<Student3>(data);
		JsonNode res = rest.postForObject(url, entity, JsonNode.class);
		return res.get("name").asText();
	}
	
	public Student3 update(String key, Student3 data) {
		HttpEntity<Student3> entity = new HttpEntity<Student3>(data);
		rest.put(getURL(key), entity);
		return data;
	}
	
	public void delete(String key) {
		rest.delete(getURL(key));
	}
}
package edu.poly.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.poly.dao.AccountDAO;
import edu.poly.dao.AuthorityDAO;
import edu.poly.dao.RoleDAO;

@RestController
public class AuthorityRestController {
	@Autowired
	AccountDAO accountDAO;
	@Autowired
	RoleDAO roleDAO;
	@Autowired
	AuthorityDAO authorityDAO;
	
	@GetMapping("/rest/authorities")
	public Map<String, Object> getAuthorities(){
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("accounts", this.accountDAO.findAll());
		data.put("roles", this.roleDAO.findAll());
		data.put("authorities", this.authorityDAO.findAll());

		return data;
	}
}

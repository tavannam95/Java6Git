package edu.poly.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.poly.entities.Account;
import edu.poly.entities.Authority;
import edu.poly.entities.Product;
import edu.poly.service.AccountService;
import edu.poly.service.AuthorityService;
import edu.poly.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	AuthorityService authorityService;
	
	@Autowired
	AccountService accountService;
	
	@Autowired
	ProductService productService;
	
	@RequestMapping("/product/list")
	public String list(
				Model model,
				@RequestParam("cid") Optional<String> cid
			) {
		Account account = this.accountService.findById("admin").get();
		String[] roles = new String[account.getAuthorities().size() + 1];
		for (int i = 0; i < account.getAuthorities().size(); i++) {
			roles[i] = account.getAuthorities().get(i).getRole().getId();
		}
		System.out.println(roles[0]);
		if (cid.isPresent()) {
			List<Product> items = productService.findByCategoryId(cid.get());
			model.addAttribute("items", items);
		} else {
			List<Product> items = productService.findAll();
			model.addAttribute("items", items);
		}
		
		return "product/list";
	}
	
	@RequestMapping("/product/detail/{id}")
	public String detail(
				Model model,
				@PathVariable("id") Integer id
			) {
		Product item = this.productService.findById(id).get();
		model.addAttribute("item", item);
		return "product/detail";
	}
	
}

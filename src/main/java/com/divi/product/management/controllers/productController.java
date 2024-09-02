package com.divi.product.management.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.divi.product.management.models.product;
import com.divi.product.management.service.productService;

import jakarta.servlet.http.HttpSession;



@Controller
public class productController {

	@Autowired
	private productService service;
	
	@GetMapping("/")
	public String home(Model m)
	{
		System.out.println("get all products");
		List<product> product=service.findAllProducts();	
		m.addAttribute("product",product);
	    return "index";	
	}
	
	
	@GetMapping("/addProduct")
	public String addProductForm()
	{
		System.out.println("add product");
		return "addProduct";
	}

	@PostMapping("/addProduct")
	public String productRegister(@ModelAttribute product e,HttpSession session) {
		System.out.println("save product");
		service.saveProduct(e);
		session.setAttribute("msg","Product Added Sucessfully... ");
		return "redirect:/";
	}
}

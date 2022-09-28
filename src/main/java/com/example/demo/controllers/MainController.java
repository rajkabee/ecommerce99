package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.entity.Product;
import com.example.demo.model.entity.ProductCategory;
import com.example.demo.model.repos.ProductCategoryRepository;
import com.example.demo.model.repos.ProductRepository;

@Controller
public class MainController {
	@Autowired
	ProductRepository productRepo;
	
	@Autowired
	ProductCategoryRepository catRepo;
	
	@RequestMapping("/")
	public String home(Model model, HttpSession session) {
		List<Long> cartItems = (List<Long>) session.getAttribute("products_in_cart");
		ArrayList<Product> cart = new ArrayList<>();
		if(cartItems!=null) {
			for(long i:cartItems) {
				cart.add(productRepo.findById(i).get());
			}
		}
		model.addAttribute("cart",cart);
		List<ProductCategory> catList = catRepo.findAll();
		model.addAttribute("categories",catList);
		Pageable page = PageRequest.of(2, 10);
		List<Product> products = productRepo.findByCategoryId(1, page);
		model.addAttribute("products",products);
		return "index";
	}
	
	@RequestMapping("/checkout")
	public String checkout() {
		return "checkout";
	}
	
	
	
	
}

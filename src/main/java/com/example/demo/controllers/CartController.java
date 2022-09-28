package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.entity.Product;
import com.example.demo.model.repos.ProductRepository;

@Controller
public class CartController {
	@Autowired
	ProductRepository productRepo;
	
	@RequestMapping("/cart")
	public String cart(HttpSession session, Model model) {
		List<Long> cartItems = (List<Long>) session.getAttribute("products_in_cart");
		ArrayList<Product> cart = new ArrayList<>();
		if(cartItems!=null) {
			for(long i:cartItems) {
				cart.add(productRepo.findById(i).get());
			}
		}
		model.addAttribute("cart",cart);
		return "cart";
	}
	
	@RequestMapping("/addToCart/{pid}")
	public String addToCart(@PathVariable long pid, HttpSession session, Model model) {
		ArrayList<Long> cart=(ArrayList<Long>) session.getAttribute("products_in_cart");
		if(cart==null) {
			cart = new ArrayList<Long>();
		}
		cart.add(pid);
		session.setAttribute("products_in_cart", cart);
		model.addAttribute("products_in_cart", cart);
		System.out.println("\n\n\n\n\n");
		System.out.println(session.getAttribute("products_in_cart"));
		return "redirect:/";
	}
}

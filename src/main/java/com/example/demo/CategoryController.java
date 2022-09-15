package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/categories")
public class CategoryController {
	@GetMapping("/addCategory")
	public String addCategoryForm() {
		return "categoryForm";
	}
	
}

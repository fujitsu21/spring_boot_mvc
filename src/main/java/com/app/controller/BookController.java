package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.model.Book;

@Controller
public class BookController {
	
	@GetMapping("/")
	public String index(@ModelAttribute Book book) {
		return "index";
	}
	
	@PostMapping("/")
	public String confirm(@Validated @ModelAttribute Book book, BindingResult result) {
		if(result.hasErrors()) {
			// if error exist => index.html
			return "index";
		}
		return "confirm";
	}
}

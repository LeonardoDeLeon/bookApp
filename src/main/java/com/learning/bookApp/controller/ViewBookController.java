package com.learning.bookApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.learning.bookApp.dao.BookRepository;

@Controller
public class ViewBookController {
	@Autowired
	BookRepository repo;
	
	@GetMapping("/viewBookDetail/{id}")
	public String viewBook(@PathVariable String id, Model model) {
		model.addAttribute("book",repo.findById(Integer.parseInt(id)).orElseThrow(IllegalArgumentException::new));
		return "viewBookDetail";
	}

}

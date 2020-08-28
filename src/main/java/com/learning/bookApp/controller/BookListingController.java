package com.learning.bookApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.learning.bookApp.dao.BookRepository;

@Controller
public class BookListingController {
	@Autowired
	BookRepository repo;
	
	@GetMapping("/bookListing")
	public String bookListing(Model model) {
		model.addAttribute("books",repo.findAll());
		return "bookListing";
	}
	
	@GetMapping("/deleteBookResultView/{id}")
	public String delBook(@PathVariable String id, Model model) {
		model.addAttribute("result",repo.deleteById(Integer.parseInt(id)));
		return "deleteBookResultView";
	}

}

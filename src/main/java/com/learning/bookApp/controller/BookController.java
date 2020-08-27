package com.learning.bookApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.bookApp.dao.BookRepository;
import com.learning.bookApp.model.Book;

@RestController
public class BookController {
	@Autowired
	private BookRepository repo;
	
	@RequestMapping("/getbooks")
	public List<Book> getAll() {
		List<Book> books = repo.findAll();
		return books;
	}
}

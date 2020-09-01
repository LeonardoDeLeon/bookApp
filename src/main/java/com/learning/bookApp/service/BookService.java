package com.learning.bookApp.service;

import java.sql.Date;

import org.springframework.stereotype.Service;

import com.learning.bookApp.model.Book;
import com.learning.bookApp.validator.AddBookForm;
import com.learning.bookApp.validator.UpdateBookForm;

@Service
public class BookService {

	public Book initBookFromUpdateBookForm(UpdateBookForm updateBookForm) throws Exception {
		
		Book book = new Book(Integer.parseInt(updateBookForm.getIsbn()),
								updateBookForm.getTitle(),
								updateBookForm.getAuthor(),
								Date.valueOf(updateBookForm.getPublishedDate()),
								updateBookForm.getPublisherName(),
								Double.parseDouble(updateBookForm.getPrice()));
		return book;
	}

	public Book initBookFromAddBookForm(AddBookForm addBookForm) {
		Book book = new Book(addBookForm.getTitle(),
				addBookForm.getAuthor(),
				Date.valueOf(addBookForm.getPublishedDate()),
				addBookForm.getPublisherName(),
				Double.parseDouble(addBookForm.getPrice()));
		return book;
	}
}

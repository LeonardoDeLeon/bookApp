package com.learning.bookApp.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.learning.bookApp.model.Book;

@Repository
public interface BookRepository {
	List<Book> findAll();
}

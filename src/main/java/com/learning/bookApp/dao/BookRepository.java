package com.learning.bookApp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.learning.bookApp.model.Book;

@Repository
public interface BookRepository {
	int save(Book book);
	int update(Book book);
	List<Book> findAll();
	Optional<Book> findById(int isbn);
	int deleteById(int isbn);
	List<Book> searchBookByStrLit(String str); //search book by string literal - ie, 'abc'
}

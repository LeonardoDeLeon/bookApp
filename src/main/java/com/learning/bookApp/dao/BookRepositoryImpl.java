package com.learning.bookApp.dao;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.learning.bookApp.model.Book;

@Repository
public class BookRepositoryImpl implements BookRepository{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static final String SQL = "select * from book";
	
	@Override
	public List<Book> findAll() {
		List<Book> books = new ArrayList<>();
		List<Map<String,Object>> rows = jdbcTemplate.queryForList(SQL);
		
		for (Map<String,Object> row : rows) {
			Book book = new Book();
			book.setIsbn((int)row.get("ISBN"));
			book.setTitle((String)row.get("Title"));
			book.setAuthor((String)row.get("Author"));
			book.setPublishedDate((Date)row.get("PublishedDate"));
			book.setPublisherName((String)row.get("PublisherName"));
			BigDecimal bad = (BigDecimal) row.get("Price");
			book.setPrice(bad.doubleValue());
			
			books.add(book);
		}
		return books;
	}
}

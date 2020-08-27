package com.learning.bookApp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.learning.bookApp.model.Book;

@Repository
public class BookRepositoryImpl implements BookRepository{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
    @Override
    public int save(Book book) {
        return jdbcTemplate.update(
                "insert into book (Title,Author,PublishedDate,PublisherName,Price) values(?,?,?,?,?)",
                book.getTitle(), book.getAuthor(), 
                book.getPublishedDate(), book.getPublisherName(), 
                book.getPrice());
    }

    @Override
    public int update(Book book) {
        return jdbcTemplate.update(
                "update book set Title = ?, Author = ?, PublishedDate = ?, PublisherName = ?, Price = ? where isbn = ?",
                book.getTitle(), book.getAuthor(), 
                book.getPublishedDate(), book.getPublisherName(), 
                book.getPrice(), book.getIsbn());
    }
	
	@Override
	public List<Book> findAll() {
		return jdbcTemplate.query("select * from book",
				(rs,row)->new Book(
						rs.getInt("ISBN"),
						rs.getString("Title"),
						rs.getString("Author"),
						rs.getDate("PublishedDate"),
						rs.getString("PublisherName"),
						rs.getBigDecimal("Price").doubleValue()
						)
				);
	}
	
	@Override
	public Optional<Book> findById(int isbn) {
		return jdbcTemplate.queryForObject(
				"select * from book where isbn = ?", 
				new Object[]{isbn},
				(rs,row) -> 
					Optional.of(new Book(
							rs.getInt("ISBN"),
							rs.getString("Title"),
							rs.getString("Author"),
							rs.getDate("PublishedDate"),
							rs.getString("PublisherName"),
							rs.getBigDecimal("Price").doubleValue()
					))
		);
	}
	
    @Override
    public int deleteById(int isbn) {
        return jdbcTemplate.update(
                "delete from book where isbn = ?",
                isbn);
    }
}

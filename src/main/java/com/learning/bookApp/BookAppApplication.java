package com.learning.bookApp;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import com.learning.bookApp.dao.BookRepository;
import com.learning.bookApp.model.Book;


@SpringBootApplication
public class BookAppApplication implements CommandLineRunner {
    private static final Logger log = LoggerFactory.getLogger(BookAppApplication.class);
    
    @Autowired
    JdbcTemplate jdbcTemplate;
    
    @Autowired
    @Qualifier("bookRepositoryImpl")
    private BookRepository bookRepository;
    
	public static void main(String[] args) {
		log.info("Start Book Management App...");
		SpringApplication.run(BookAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		log.info("runJDBC()");
		runJDBC();
	}
	
	void runJDBC() {
//		List<Book> books =  new ArrayList<>();
//		books.add(new Book("A is for Apple","Jack Appleby",Date.valueOf("1942-11-12"),"XYZ Publishing",1.95));
//		books.add(new Book("B is for Banana","Tom Bane",Date.valueOf("1945-01-15"),"XYZ Publishing",2.95));
//		books.add(new Book("C is for Cocoa","Courtney Cruz",Date.valueOf("1946-02-14"),"XYZ Publishing",3.95));
//
//		log.info("[FIND_ALL] b4 {}",bookRepository.findAll());

//		log.info("add new books with save()");
//		books.forEach(book -> {
//			log.info("Saving...{}",book.getTitle());
//			bookRepository.save(book);
//		});
//		
//		log.info("[FIND_ALL] afta {}",bookRepository.findAll());
		
//		log.info("[FIND_BY_ID] : 4");
//		Book book = bookRepository.findById(4).orElseThrow(IllegalArgumentException::new);
//		log.info("{}",book);
//		System.out.println("Title: "+book.getTitle());
		
//        log.info("[UPDATE] :4 :AAA is For AAApple : 8.87");
//        book.setPrice(8.87);
//        book.setTitle("AAA is For AAApple");
//        log.info("rows affected: {}", bookRepository.update(book));

//        log.info("[DELETE] :4");
//        log.info("rows affected: {}", bookRepository.deleteById(4));

//        List<Book> list = bookRepository.findAll();
//        for (Book b : list) {
//        	System.out.println("-------\n");
//        	System.out.println("ISBN: "+b.getIsbn());
//        	System.out.println("Title: "+b.getTitle());
//        	System.out.println("Author: "+b.getAuthor());
//        	System.out.println("PublishedDate: "+b.getPublishedDate());
//        	System.out.println("PubliherName: "+b.getPublisherName());
//        	System.out.println("Price: "+b.getPrice());
//        }
	}

}

package com.learning.bookApp.model;

import java.sql.Date;

public class Book {
	private int isbn;
	private String title;
	private String author;
	private Date publishedDate;
	private String publisherName;
	private double price;
	
	public Book() {}

	public Book(int isbn, String title, String author, 
			Date publishedDate, String publisherName, double price) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publishedDate = publishedDate;
		this.publisherName = publisherName;
		this.price = price;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(Date date) {
		this.publishedDate = date;
	}

	public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}

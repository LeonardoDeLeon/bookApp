package com.learning.bookApp.validator;

public class UpdateBookForm {
	
	private String isbn;
	private String title;
	private String author;
	private String publishedDate;
	private String publisherName;
	private String price;
		
	public UpdateBookForm() {}

	public UpdateBookForm(String title, String author, String publishedDate, String publisherName, String price) {
		super();
		this.title = title;
		this.author = author;
		this.publishedDate = publishedDate;
		this.publisherName = publisherName;
		this.price = price;
	}
	
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
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

	public String getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(String publishedDate) {
		this.publishedDate = publishedDate;
	}

	public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
}

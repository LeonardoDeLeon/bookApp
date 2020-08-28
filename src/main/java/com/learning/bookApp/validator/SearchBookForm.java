package com.learning.bookApp.validator;

public class SearchBookForm {
	private String searchField;
	
	

	public SearchBookForm() {
		super();
	}

	public SearchBookForm(String searchField) {
		super();
		this.searchField = searchField;
	}

	public String getSearchField() {
		return searchField;
	}

	public void setSearchField(String searchField) {
		this.searchField = searchField;
	}
}

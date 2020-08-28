package com.learning.bookApp.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class AddBookFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz == AddBookForm.class;
	}

	@Override
	public void validate(Object target, Errors errors) {
		AddBookForm addBookForm = (AddBookForm) target;
		
		// form fields must not be blank
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "NotEmpty.addBookForm.title");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "author", "NotEmpty.addBookForm.author");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "publishedDate", "NotEmpty.addBookForm.publishedDate");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "publisherName", "NotEmpty.addBookForm.publisherName");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "NotEmpty.addBookForm.price");
		
		// if publishedDate is not empty
		if (addBookForm.getPublishedDate() == null) {
			errors.rejectValue("publishedDate","NotEmpty.addBookForm.publihedDate");
		}
		
	}
	
	
}

package com.learning.bookApp.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UpdateBookFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz == UpdateBookForm.class;
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "NotEmpty.updateBookForm.title");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "author", "NotEmpty.updateBookForm.author");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "publishedDate", "NotEmpty.updateBookForm.publishedDate");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "publisherName", "NotEmpty.updateBookForm.publisherName");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "NotEmpty.updateBookForm.price");

	}

}

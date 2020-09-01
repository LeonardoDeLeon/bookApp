	package com.learning.bookApp.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class SearchBookFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz == SearchBookForm.class;
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "searchField", "NotEmpty.searchBookForm.searchField");
	}

}

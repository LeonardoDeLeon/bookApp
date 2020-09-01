package com.learning.bookApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.learning.bookApp.dao.BookRepository;
import com.learning.bookApp.model.Book;
import com.learning.bookApp.service.BookService;
import com.learning.bookApp.validator.SearchBookForm;
import com.learning.bookApp.validator.SearchBookFormValidator;
import com.learning.bookApp.validator.UpdateBookForm;
import com.learning.bookApp.validator.UpdateBookFormValidator;

@Controller
public class SearchBookController {
	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	BookService bookService;
	
	@Autowired
	private SearchBookFormValidator searchBookFormValidator;
	
	// set a form validator
	@InitBinder
	protected void initBinder(WebDataBinder dataBinder) {
		// form target
		Object target = dataBinder.getTarget();
		if (target == null) {
			return;
		}
		
		if (target.getClass() == SearchBookForm.class) {
			dataBinder.setValidator(searchBookFormValidator);
		}
	}
	
	@GetMapping("searchBookForm")
	public ModelAndView searchBookForm() {
		ModelAndView modelAndView = new ModelAndView();
		SearchBookForm bookForm = new SearchBookForm();
		modelAndView.addObject("searchBookForm",bookForm);
		modelAndView.setViewName("searchBookForm"); //resources/template/searchBookForm
		System.out.println("modelAndView: "+modelAndView);
		return modelAndView;
	}
	
	@PostMapping("/searchBookForm")
	public String searchBook(Model model,
			@ModelAttribute("searchBookForm") @Validated SearchBookForm searchBookForm, 
			BindingResult result) throws Exception {
		
		model.addAttribute("searchBookForm",searchBookForm);
		// if form has errors then prompt user to make corrections
		if (result.hasErrors()) return "searchBookForm";
		
		//if no errors in the form, then proceed with adding the new book
		model.addAttribute("bookList",bookRepository.findByTitle(searchBookForm.getSearchField()));
		return "searchBookResultView";
	}
}

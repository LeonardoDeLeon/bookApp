package com.learning.bookApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.learning.bookApp.dao.BookRepository;
import com.learning.bookApp.model.Book;
import com.learning.bookApp.service.BookService;
import com.learning.bookApp.validator.AddBookForm;
import com.learning.bookApp.validator.AddBookFormValidator;

@Controller
public class AddBookController {
	
	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	BookService bookService;
	
	@Autowired
	private AddBookFormValidator addBookFormValidator;
	
	// set a form validator
	@InitBinder
	protected void initBinder(WebDataBinder dataBinder) {
		// form target
		Object target = dataBinder.getTarget();
		if (target == null) {
			return;
		}
		
		if (target.getClass() == AddBookForm.class) {
			dataBinder.setValidator(addBookFormValidator);
		}
	}
	
	@GetMapping("addBookForm")
	public ModelAndView addBookForm() {
		ModelAndView modelAndView = new ModelAndView();
		AddBookForm bookForm = new AddBookForm();
		modelAndView.addObject("addBookForm",bookForm);
		modelAndView.setViewName("addBookForm"); //resources/template/addBookForm
		System.out.println("modelAndView: "+modelAndView);
		return modelAndView;
	}
	
	@PostMapping("/addBookForm")
	public String addBook(Model model,
			@ModelAttribute("addBookForm") @Validated AddBookForm addBookForm, 
			BindingResult result) throws Exception {
		
		model.addAttribute("addBookForm",addBookForm);
		Book newBook = bookService.initBookFromAddBookForm(addBookForm);
		// if form has errors then prompt user to make corrections
		if (result.hasErrors()) return "addBookForm";
		
		//if no errors in the form, then proceed with adding the new book
		model.addAttribute("result",bookRepository.save(newBook));
		return "addBookResultView";
	}
}

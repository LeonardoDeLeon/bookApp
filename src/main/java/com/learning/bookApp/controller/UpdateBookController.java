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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.learning.bookApp.dao.BookRepository;
import com.learning.bookApp.model.Book;
import com.learning.bookApp.service.BookService;
import com.learning.bookApp.validator.UpdateBookForm;
import com.learning.bookApp.validator.UpdateBookFormValidator;

@Controller
public class UpdateBookController {
	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	BookService bookService;
	
	@Autowired
	private UpdateBookFormValidator updateBookFormValidator;
	
	// set a form validator
	@InitBinder
	protected void initBinder(WebDataBinder dataBinder) {
		// form target
		Object target = dataBinder.getTarget();
		if (target == null) {
			return;
		}
		
		if (target.getClass() == UpdateBookForm.class) {
			dataBinder.setValidator(updateBookFormValidator);
		}
	}
	
	@GetMapping("/updateBookForm/{id}")
	public ModelAndView updateBookForm(@PathVariable String id) {
		Book book = bookRepository.findById(Integer.parseInt(id)).orElseThrow(IllegalArgumentException::new);
		ModelAndView modelAndView = new ModelAndView();
		UpdateBookForm bookForm = new UpdateBookForm();
		bookForm.setIsbn(Integer.toString(book.getIsbn()));
		bookForm.setTitle(book.getTitle());
		bookForm.setAuthor(book.getAuthor());
		bookForm.setPublishedDate(book.getPublishedDate().toString());
		bookForm.setPublisherName(book.getPublisherName());
		bookForm.setPrice(Double.toString(book.getPrice()));
		modelAndView.addObject("updateBookForm",bookForm);
		modelAndView.setViewName("updateBookForm"); //resources/template/addBookForm
		System.out.println("modelAndView: "+modelAndView);
		return modelAndView;
	}
	
	@PostMapping("/updateBookForm")
	public String updateBook(Model model,
			@ModelAttribute("updateBookForm") @Validated UpdateBookForm updateBookForm, 
			BindingResult result) throws Exception {
		
		model.addAttribute("updateBookForm",updateBookForm);
		
		// if form has errors then prompt user to make corrections
		if (result.hasErrors()) return "updateBookForm";
		
		//if no errors in the form, then proceed with adding the new book
		Book updatedBook = bookService.initBookFromUpdateBookForm(updateBookForm);
		model.addAttribute("result",bookRepository.update(updatedBook));
		return "updateBookResultView";
	}
}

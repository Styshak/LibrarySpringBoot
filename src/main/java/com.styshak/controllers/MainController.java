package com.styshak.controllers;

import com.styshak.domains.Book;
import com.styshak.domains.User;
import com.styshak.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class MainController {

	@Autowired
	private BookService bookService;

	@RequestMapping(value = {"/", "/index"})
	public ModelAndView getBooks(@RequestParam(value = "genreId", required = false) Long genreId) {
		ModelAndView modelAndView = new ModelAndView("/index");

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User) authentication.getPrincipal();
		modelAndView.addObject("username", user.getUsername());

		if(genreId != null) {
			Page<Book> books = bookService.getBooksByGenre(1, genreId);
			modelAndView.addObject("books", books);
		}
		return modelAndView;
	}
}

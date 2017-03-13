package com.styshak.controllers;

import com.styshak.domains.Book;
import com.styshak.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("index/search")
public class MainController {

	@Autowired
	private BookService bookService;

	@RequestMapping
	public ModelAndView getBooks(@RequestParam(value = "genreId", required = false) Long genreId) {
		ModelAndView modelAndView = new ModelAndView("/index");
		if(genreId != null) {
			Page<Book> books = bookService.getBooksByGenre(1, genreId);
			modelAndView.addObject("books", books);
		}
		return modelAndView;
	}
}

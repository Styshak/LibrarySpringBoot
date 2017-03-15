package com.styshak.controllers;

import com.styshak.domains.Book;
import com.styshak.domains.User;
import com.styshak.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class MainController {

	@Autowired
	private BookService bookService;

	@RequestMapping(value = {"/", "/index"})
	public ModelAndView renderBooks(@RequestParam(value = "genreId", required = false) Long genreId,
								 	@RequestParam(value = "letter", required = false) String letter,
								 	@RequestParam(value = "title", required = false) String title,
								 	@RequestParam(value = "author", required = false) String author,
									@RequestParam(value = "page", required = false) Integer page) {
		ModelAndView modelAndView = new ModelAndView("/index");

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User) authentication.getPrincipal();
		modelAndView.addObject("username", user.getUsername());

		Page<Book> books = getBooks(genreId, letter, title, author, page);

		modelAndView.addObject("books", books);

		return modelAndView;
	}

	@RequestMapping (value="/img/book/{id}", method = RequestMethod.GET)
	public ResponseEntity<byte[]> getBookImage(@PathVariable final long id) {
		byte[] bytes = bookService.getBookImage(id);

		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_JPEG);

		return new ResponseEntity<>(bytes, headers, HttpStatus.CREATED);
	}

	private Page<Book> getBooks(Long genreId, String letter, String title, String author, Integer page) {
		int selectedPage = page == null ? 1 : page;
		if(genreId != null) {
			return bookService.getBooksByGenre(selectedPage, genreId);
		} else if(letter != null) {
			return bookService.getBooksByLetter(selectedPage, letter);
		} else if(title != null) {
			return bookService.getBooksByTitle(selectedPage, title);
		} else if(author != null) {
			return bookService.getBooksByAuthor(selectedPage, author);
		}
		return bookService.getAllBooks(selectedPage);
	}
}

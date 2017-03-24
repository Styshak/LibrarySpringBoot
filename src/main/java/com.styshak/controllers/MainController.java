package com.styshak.controllers;

import com.styshak.domains.Book;
import com.styshak.domains.User;
import com.styshak.enums.SearchType;
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
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.net.URLEncoder;

@Controller
@RequestMapping("/")
public class MainController {

	@Autowired
	private BookService bookService;

	@ModelAttribute("book")
	public Book getBook() {
		return new Book();
	}

	@RequestMapping(value = {"/genre/{id}", "/genre/{id}/page/{pageNumber}"}, method = RequestMethod.GET)
	public ModelAndView getBooksByGenre(@PathVariable(value = "id") Long id,
										@PathVariable(value = "pageNumber", required = false) Integer pageNumber) {
		int page = pageNumber == null ? 1 : pageNumber;
		Page<Book> books = bookService.getBooksByGenre(page, id);
		ModelAndView modelAndView = getModelAndView(books, page);
		modelAndView.addObject("pageUrl", "/genre/" + id);
		modelAndView.addObject("books", books);
		return modelAndView;
	}

	@RequestMapping(value = {"/letter/{l}", "/letter/{l}/page/{pageNumber}"}, method = RequestMethod.GET)
	public ModelAndView getBooksByLetter(@PathVariable(value = "l") String letter,
										@PathVariable(value = "pageNumber", required = false) Integer pageNumber) {
		int page = pageNumber == null ? 1 : pageNumber;
		Page<Book> books = bookService.getBooksByLetter(page, letter);
		ModelAndView modelAndView = getModelAndView(books, page);
		modelAndView.addObject("pageUrl", "/letter/" + letter);
		modelAndView.addObject("books", books);
		return modelAndView;
	}

	@RequestMapping(value = {"/search/type/{searchType}/text/{searchText}", "/search/type/{searchType}/text/{searchText}/page/{pageNumber}"}, method = RequestMethod.GET)
	public ModelAndView getBooksBySearch(@PathVariable(value = "searchText") String searchText,
										 @PathVariable(value = "searchType") SearchType searchType,
										 @PathVariable(value = "pageNumber",required = false) Integer pageNumber) {

		Page<Book> books;
		int page = pageNumber == null ? 1 : pageNumber;

		if(searchText.isEmpty()) {
			books = bookService.getAllBooks(page);
		} else {
			switch (searchType) {
				case TITLE:
					books = bookService.getBooksByTitle(page, searchText);
					break;
				case AUTHOR:
					books = bookService.getBooksByAuthor(page, searchText);
					break;
				default:
					books = bookService.getAllBooks(page);
			}
		}

		ModelAndView modelAndView = getModelAndView(books, page);
		modelAndView.addObject("pageUrl", "/search/type/" + searchType + "/text/" + searchText);
		modelAndView.addObject("books", books);

		return modelAndView;
	}

	@RequestMapping(value = {"/", "/page/{pageNumber}"}, method = RequestMethod.GET)
	public ModelAndView getAllBooks(@PathVariable(value = "pageNumber", required = false) Integer pageNumber) {
		int page = pageNumber == null ? 1 : pageNumber;
		Page<Book> books = bookService.getAllBooks(page);
		ModelAndView modelAndView = getModelAndView(books, page);
		modelAndView.addObject("pageUrl", "");
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

	@RequestMapping (value="/save/book/{id}", method = RequestMethod.GET)
	public void saveBook(@PathVariable final long id,
						 HttpServletResponse response) throws Exception {
		byte[] content = bookService.getBookContent(id);
		String filename = bookService.getBookNameById(id);

		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(filename, "UTF-8") + ".pdf");
		try (OutputStream out = response.getOutputStream()) {
			out.write(content);
		}
		response.flushBuffer();
	}

	@RequestMapping (value="/read/book/{id}", method = RequestMethod.GET)
	public void readBook(@PathVariable final long id,
						 HttpServletResponse response) throws Exception {
		byte[] content = bookService.getBookContent(id);

		response.setContentType("application/pdf");
		response.setContentLength(content.length);
		try (OutputStream out = response.getOutputStream()) {
			out.write(content);
		}
		response.flushBuffer();
	}

	@RequestMapping(value = "/addBook", method = RequestMethod.POST)
	public String addBook(@RequestParam(value = "currentRequest") String currentRequest,
						  @ModelAttribute("book") Book book,
						  BindingResult bindingResult) {
		return "redirect:" + currentRequest;
	}

	@RequestMapping(value = "/getBookById", method = RequestMethod.POST)
	public @ResponseBody String addBook(@RequestParam Long id, Model model) {
		Book book = bookService.findOne(id);
		model.addAttribute("book", book);
		return "{\"msg\":\"success\"}";
	}


	private String getUsername() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User) authentication.getPrincipal();
		return user.getUsername();
	}

	private ModelAndView getModelAndView(Page<Book> books, int page) {
		ModelAndView modelAndView = new ModelAndView("/index");
		modelAndView.addObject("username", getUsername());
		int current = books.getNumber() + 1;
		int begin = Math.max(1, current - 5);
		int end = Math.min(begin + 10, books.getTotalPages());
		modelAndView.addObject("beginIndex", begin);
		modelAndView.addObject("endIndex", end);
		modelAndView.addObject("currentIndex", current);

		modelAndView.addObject("books", books);
		modelAndView.addObject("searchType", SearchType.values());
		if(page > books.getTotalPages() && books.getTotalElements() > 0) {
			modelAndView.addObject("error", "unavailable.page.in.request");
		} else {
			modelAndView.addObject("error", "");
		}
		return modelAndView;
	}
}

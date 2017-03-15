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
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping
public class MainController {

	@Autowired
	private BookService bookService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView renderBooksGet(ModelMap model,
									@RequestParam(value = "genreId", required = false) Long genreId,
								 	@RequestParam(value = "letter", required = false) String letter,
								 	@RequestParam(value = "searchType", required = false) SearchType searchType,
									@RequestParam(value = "searchText", required = false) String searchText,
									@RequestParam(value = "page", required = false) Integer page) {
		ModelAndView modelAndView = new ModelAndView("/index");
		if(model.size() != 0) {
			genreId = (Long) model.get("genreId");
			letter = (String) model.get("letter");
			searchType = (SearchType) model.get("searchType");
			searchText = (String) model.get("searchText");
			page = (Integer) model.get("page");
		}

		modelAndView.addObject("username", getUsername());

		Page<Book> books = getBooks(genreId, letter, searchType, searchText, page);
		modelAndView.addObject("books", books);
		modelAndView.addObject("searchType", SearchType.values());

		return modelAndView;
	}

	@RequestMapping(value = {"/", "/index"}, method = RequestMethod.POST)
	public String renderBooksPost(RedirectAttributes redirectAttributes,
										@RequestParam(value = "genreId", required = false) Long genreId,
									    @RequestParam(value = "letter", required = false) String letter,
									    @RequestParam(value = "searchType", required = false) SearchType searchType,
									    @RequestParam(value = "searchText", required = false) String searchText,
										@RequestParam(value = "page", required = false) Integer page) {

		redirectAttributes.addFlashAttribute("genreId", genreId);
		redirectAttributes.addFlashAttribute("letter", letter);
		redirectAttributes.addFlashAttribute("searchType", searchType);
		redirectAttributes.addFlashAttribute("searchText", searchText);
		redirectAttributes.addFlashAttribute("page", page);

		return "redirect:/";
	}

	@RequestMapping (value="/img/book/{id}", method = RequestMethod.GET)
	public ResponseEntity<byte[]> getBookImage(@PathVariable final long id) {
		byte[] bytes = bookService.getBookImage(id);

		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_JPEG);

		return new ResponseEntity<>(bytes, headers, HttpStatus.CREATED);
	}

	private Page<Book> getBooks(Long genreId, String letter, SearchType searchType, String searchText, Integer page) {
		int selectedPage = page == null ? 1 : page;
		if(genreId != null) {
			return bookService.getBooksByGenre(selectedPage, genreId);
		} else if(letter != null) {
			return bookService.getBooksByLetter(selectedPage, letter);
		} else if(searchText != null && searchType != null) {
			switch (searchType) {
				case TITLE:
					return bookService.getBooksByTitle(selectedPage, searchText);
				case AUTHOR:
					return bookService.getBooksByAuthor(selectedPage, searchText);
			}
		}
		return bookService.getAllBooks(selectedPage);
	}

	private String getUsername() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User) authentication.getPrincipal();
		return user.getUsername();
	}
}

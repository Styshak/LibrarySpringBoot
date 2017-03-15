package com.styshak.services;

import com.styshak.domains.Book;
import com.styshak.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@Service
public class BookService {

	private static final int PAGE_SIZE = 6;
	private final Sort sorting = new Sort(Sort.Direction.DESC, "name");

	@Autowired
	private BookRepository bookRepository;

	@Transactional
	public Page<Book> getAllBooks(int pageNumber) {
		return bookRepository.findAll(getPageRequest(pageNumber));
	}

	@Transactional
	public Page<Book> getBooksByLetter(int pageNumber, String letter) {
		return bookRepository.findByNameStartingWithIgnoreCase(letter, getPageRequest(pageNumber));
	}

	@Transactional
	public Page<Book> getBooksByAuthor(int pageNumber, String authorName) {
		return bookRepository.findByAuthor_NameContaining(authorName, getPageRequest(pageNumber));
	}

	@Transactional
	public Page<Book> getBooksByTitle(int pageNumber, String bookName) {
		return bookRepository.findByNameContainingIgnoreCase(bookName, getPageRequest(pageNumber));
	}

	@Transactional
	public Page<Book> getBooksByGenre(int pageNumber, long genreId) {
		return bookRepository.findByGenre_Id(genreId, getPageRequest(pageNumber));
	}

	@Transactional
	public byte[] getBookContent(long bookId) {
		return bookRepository.getContent(bookId);
	}

	@Transactional
	public byte[] getBookImage(long bookId) {
		return bookRepository.getImage(bookId);
	}

	private PageRequest getPageRequest(int pageNumber) {
		return new PageRequest(pageNumber -1, PAGE_SIZE, sorting);
	}

	@PostConstruct
	void init() {
		//Page<Book> page = getAllBooks(1);
		//Page<Book> page1 = getBooksByLetter(1, "м");
		//Page<Book> page2 = getBooksByAuthor(1, "Ремарк");
		Page<Book> page3 = getBooksByTitle(1, "клык");
		//Page<Book> page4 = getBookByGenre(1, 13);
		//getBookContent(4);
	}
}

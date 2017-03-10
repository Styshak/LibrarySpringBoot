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

	private static final int PAGE_SIZE = 4;

	@Autowired
	private BookRepository bookRepository;

	@Transactional
	public Page<Book> getBookPage(int pageNumber) {
		PageRequest pageRequest =
				new PageRequest(pageNumber - 1, PAGE_SIZE, Sort.Direction.DESC, "name");
		return bookRepository.findAll(pageRequest);
	}

	@Transactional
	public Page<Book> getBooksByLetter(int pageNumber, String letter) {
		Page page = bookRepository.findByName(letter, new PageRequest(pageNumber -1,
				PAGE_SIZE, new Sort(Sort.Direction.DESC, "name")));
		return page;
	}

	@PostConstruct
	void init() {
		Page<Book> page = getBookPage(1);
		Page<Book> page1 = getBooksByLetter(1, "М");
	}
}

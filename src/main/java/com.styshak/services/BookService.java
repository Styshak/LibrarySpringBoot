package com.styshak.services;

import com.styshak.domains.Book;
import com.styshak.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
public class BookService {

	private static final int PAGE_SIZE = 3;
	private static final Sort SORTING = new Sort(Sort.Direction.ASC, "name");

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

	@Transactional
	public String getBookNameById(long bookId) {
		return bookRepository.getBookNameById(bookId);
	}

	@Transactional
	public Book findOne(Long id) {
		return bookRepository.findOne(id);
	}

	@Transactional
	public Book save(Book book) {
		Book b = bookRepository.save(book);
		if(book.getImage().length > 0) {
			bookRepository.updateImage(b.getId(), book.getImage());
			FileOutputStream stream = null;
			try {
				stream = new FileOutputStream("C:\\temp\\1.jpg");
				stream.write(book.getImage());
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					stream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		if(book.getContent().length > 0) {

		}
		return b;
	}

	@Transactional
	public void delete(long bookId) {
		bookRepository.delete(bookId);
	}

	private PageRequest getPageRequest(int pageNumber) {
		return new PageRequest(pageNumber -1, PAGE_SIZE, SORTING);
	}
}

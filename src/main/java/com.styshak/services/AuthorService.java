package com.styshak.services;

import com.styshak.domains.Author;
import com.styshak.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sergey on 17.03.17.
 */
@Service
public class AuthorService {

	@Autowired
	private AuthorRepository authorRepository;

	public List<Author> findAll() {
		List<Author> result = new ArrayList<>();
		authorRepository.findAll().forEach(result::add);
		return result;
	}
}

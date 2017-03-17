package com.styshak.services;

import com.styshak.domains.Publisher;
import com.styshak.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sergey on 17.03.17.
 */
@Service
public class PublisherService {

	@Autowired
	private PublisherRepository publisherRepository;

	public List<Publisher> findAll() {
		List<Publisher> result = new ArrayList<>();
		publisherRepository.findAll().forEach(result::add);
		return result;
	}
}

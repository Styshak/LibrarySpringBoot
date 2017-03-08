package com.styshak.services;

import com.styshak.domains.Genre;
import com.styshak.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GenreService {

    @Autowired
    private GenreRepository genreRepository;

    public List<Genre> findAll() {
        List<Genre> result = new ArrayList<>();
        genreRepository.findAll().forEach(result::add);
        return result;
    }
}

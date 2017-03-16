package com.styshak.controllers;

import com.styshak.domains.Genre;
import com.styshak.enums.SearchType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class SearchCriteria {

	private Character letter;

	private String text;

	private SearchType searchType = SearchType.TITLE;

	private Genre genre;

	private long genreId;
}

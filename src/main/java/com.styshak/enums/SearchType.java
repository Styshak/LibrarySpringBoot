package com.styshak.enums;

/**
 * Created by sergey on 09.03.17.
 */
public enum SearchType {

	TITLE("searchType.title"),
	AUTHOR("searchType.author");

	private String name;

	SearchType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}

package com.styshak.enums;

/**
 * Created by sergey on 09.03.17.
 */
public enum SearchType {
	AUTHOR("searchType.author"),
	TITLE("searchType.title");

	private String name;

	SearchType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}

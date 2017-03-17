package com.styshak.domains;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
@Data
public class Book implements Serializable {

	private static final long serialVersionUID = 159248281475168177L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column
	private String name;

	@Transient
	private byte[] content;

	@Column(name = "page_count")
	private Integer pageCount;

	@Column
	private String isbn;

	@JoinColumn(name = "genre_id")
	@ManyToOne(cascade = CascadeType.ALL)
	private Genre genre;

	@JoinColumn(name = "author_id")
	@ManyToOne(cascade = CascadeType.ALL)
	private Author author;

	@Column(name = "publish_year")
	private Integer publishYear;

	@JoinColumn(name = "publisher_id")
	@ManyToOne(cascade = CascadeType.ALL)
	private Publisher publisher;

	@Transient
	private byte[] image;

	@Column
	private String description;

	@Column
	private long rating;

	@Column(name = "vote_count")
	private long voteCount;
}

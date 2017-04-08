package com.styshak.domains;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class Book implements Serializable {

	private static final long serialVersionUID = 159248281475168177L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column
	private String name;

	@Column(name = "page_count")
	private Integer pageCount;

	@Column
	private String isbn;

	@JoinColumn(name = "genre_id")
	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Genre genre;

	@JoinColumn(name = "author_id")
	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Author author;

	@Column(name = "publish_year")
	private Integer publishYear;

	@JoinColumn(name = "publisher_id")
	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Publisher publisher;

	@Column
	private String description;

	@Column
	private long rating;

	@Column(name = "vote_count")
	private long voteCount;

	@Transient
	private MultipartFile content;

	@Transient
	private MultipartFile image;
}

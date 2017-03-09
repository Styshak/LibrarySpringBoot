package com.styshak.domains;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
@Data
public class Author implements Serializable {

	private static final long serialVersionUID = 5817222898158807483L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column
	private String name;
}

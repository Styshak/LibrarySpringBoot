package com.styshak.domains;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
@Data
public class Publisher implements Serializable {

	private static final long serialVersionUID = -3216520028309047813L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column
	private String name;
}

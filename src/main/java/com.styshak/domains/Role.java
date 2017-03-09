package com.styshak.domains;


import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table
public class Role implements GrantedAuthority, Serializable {

	private static final long serialVersionUID = -2265740618725191010L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column
	private String authority;
}

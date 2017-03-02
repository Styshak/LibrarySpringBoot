package com.styshak.domains;


import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table
public class User implements UserDetails, Serializable, Cloneable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "user_in_group", joinColumns = { @JoinColumn(name = "userId") }, inverseJoinColumns = { @JoinColumn(name = "groupId") })
	private Set<Role> authorities = new HashSet<>(0);

	@Column @Size(min = 5)
	private String username;

	@Column @Size(min = 5)
	private String password;

	@Transient
	private String confirmPassword;

	@Getter(AccessLevel.NONE) @Transient
	private boolean confirmedPassword;

	@Column
	private boolean accountNonExpired = true;

	@Column
	private boolean accountNonLocked = true;

	@Column
	private boolean credentialsNonExpired = true;

	@Column
	private boolean enabled = true;

	@AssertTrue
	public boolean isConfirmedPassword() {
		if(this.password == null || this.confirmPassword == null) {
			return true;
		}
		boolean confirmed = password.equals(confirmPassword);
		setConfirmedPassword(confirmed);
		return confirmedPassword;
	}

	@Override
	public User clone() {
		try {
			return (User)super.clone();
		}
		catch( CloneNotSupportedException ex ) {
			throw new InternalError();
		}
	}
}

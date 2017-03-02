package com.styshak.services;

import com.styshak.domains.User;
import com.styshak.exceptions.UserAlreadyExist;
import com.styshak.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetails user = userRepository.findByUsername(username);
		if(user == null)
			throw new UsernameNotFoundException("Incorrect username or password");
		return user;
	}

	@Transactional
	public void save(User user) throws Exception {
		User duplicate = userRepository.findByUsername(user.getUsername());
		if(duplicate != null) throw new UserAlreadyExist();

		User encodedUser = user.clone();
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		encodedUser.setPassword(encodedPassword);
		encodedUser.setConfirmPassword(encodedPassword);
		userRepository.save(encodedUser);
	}
}

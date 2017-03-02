package com.styshak.controllers;

import com.styshak.domains.User;
import com.styshak.exceptions.UserAlreadyExist;
import com.styshak.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class RegisterController {

	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String getRegisterPage(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@Valid @ModelAttribute("user") User user,
						   BindingResult result,
						   HttpServletRequest request,
						   Model model) {
		if(result.hasErrors()) {
			return "register";
		}
		try {
			userService.save(user);
		} catch (UserAlreadyExist e) {
			model.addAttribute("userAlreadyExist", true);
			return "register";
		} catch (Exception e) {
			return "register";
		}
		autoLogin(user, request);
		return "redirect:/index/";
	}

	private void autoLogin(User user, HttpServletRequest request) {
		try {
			UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(), user.getAuthorities());

			// generate session if one doesn't exist
			request.getSession();

			token.setDetails(new WebAuthenticationDetails(request));
			Authentication authenticatedUser = authenticationManager.authenticate(token);

			SecurityContextHolder.getContext().setAuthentication(authenticatedUser);
		} catch (Exception e) {
			SecurityContextHolder.getContext().setAuthentication(null);
		}

	}
}

package com.denlex.superoptimum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Shishkov A.V. on 10.08.18.
 */
@Controller
@RequestMapping(path = "")
public class WelcomeController {

	@GetMapping(value="/login")
	public String showLoginPage(Model model) {
		return "login";
	}

	@PostMapping
	public String signUpUser() {
		return "index";
	}
}

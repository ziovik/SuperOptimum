package com.denlex.superoptimum.controller;

import com.denlex.superoptimum.dto.UserKind;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Shishkov A.V. on 10.08.18.
 */
@Controller
@RequestMapping(path = "")
public class WelcomeController {

	@GetMapping(value="/login{user_kind}")
	public String showLoginPage(@PathVariable("user_kind") String userKind, Model model) {
		UserKind user;
		if (userKind.equalsIgnoreCase("customer")) {
			user = UserKind.CUSTOMER;
		} else {
			user = UserKind.DISTRIBUTOR;
		}
		model.addAttribute("userKind", user);
		return "login";
	}
}

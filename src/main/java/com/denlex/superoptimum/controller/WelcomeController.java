package com.denlex.superoptimum.controller;

import com.denlex.superoptimum.dto.UserKind;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Shishkov A.V. on 10.08.18.
 */
@Controller
@RequestMapping(path = "")
public class WelcomeController {

	/*@ModelAttribute
	public void addAttributes(Model model) {
		model.addAttribute("userKind", UserKind.DISTRIBUTOR);
	}*/

	@GetMapping(path = {"", "/index"})
	public String showIndexPage() {
		return "index";
	}

	@GetMapping("/loading_c")
	public String showWelcomeCustomerPage(Model model) {
		model.addAttribute("userKind", UserKind.CUSTOMER);
		return "loading_c";
	}

	@GetMapping("/loading_d")
	public String showWelcomeDistributorPage(Model model) {
		model.addAttribute("userKind", UserKind.DISTRIBUTOR);
		return "loading_d";
	}

	@GetMapping("/login")
	public String showLoginPage() {
		return "login";
	}

	@GetMapping("/main")
	public String showMainPage(@ModelAttribute String userKind) {
		return "main";
	}

}

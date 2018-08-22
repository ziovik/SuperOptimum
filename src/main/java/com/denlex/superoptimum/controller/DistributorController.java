package com.denlex.superoptimum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Shishkov A.V. on 19.08.18.
 */
@Controller
@RequestMapping("/distributor")
public class DistributorController {

	@GetMapping("/loading")
	public String showLoadingPage() {
		return "distributor/loading";
	}

	@GetMapping("/login")
	public String showLoginPage() {
		return "distributor/login";
	}

	@GetMapping("/main")
	public String showMainPage() {
		return "distributor/main";
	}
}

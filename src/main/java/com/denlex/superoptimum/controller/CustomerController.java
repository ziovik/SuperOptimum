package com.denlex.superoptimum.controller;

import com.denlex.superoptimum.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Shishkov A.V. on 19.08.18.
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private ProductService productService;

	@GetMapping("/loading")
	public String showLoadingPage() {
		return "customer/loading";
	}

	@GetMapping("/login")
	public String showLoginPage() {
		return "customer/login";
	}

	@GetMapping("/main")
	public String showMainPage() {

		return "customer/main";
	}
}

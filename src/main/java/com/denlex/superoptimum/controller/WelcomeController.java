package com.denlex.superoptimum.controller;

import com.denlex.superoptimum.domain.product.Category;
import com.denlex.superoptimum.domain.user.Customer;
import com.denlex.superoptimum.service.product.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

/**
 * Created by Shishkov A.V. on 10.08.18.
 */
@Controller
public class WelcomeController {

	@Autowired
	private CategoryService categoryService;

	@ModelAttribute
	public void addAttributes(Model model) {
		model.addAttribute("userIndex", 0);
	}

	@GetMapping(path = {"", "/index"})
	public String showIndexPage() {
		return "index";
	}

	@GetMapping("/customer/loading")
	public String showWelcomeCustomerPage() {
		return "customer/loading";
	}

	@GetMapping("/distributor/loading")
	public String showWelcomeDistributorPage() {
		return "distributor/loading";
	}

	@GetMapping("/customer/login")
	public String showCustomerLoginPage() {
		return "customer/login";
	}

	@GetMapping("/distributor/login")
	public String showDistributorLoginPage() {
		return "distributor/login";
	}

	@GetMapping("/customer/optimum_beauty")
	public String showMainPage(@ModelAttribute("user") Customer user, Model model) {
		List<Category> categories = categoryService.findAll();
		model.addAttribute("categories", categories);
		return "customer/optimum_beauty";
	}

	@GetMapping("/distributor/index_distributor")
	public String showDistributorMainPage() {
		return "distributor/index_distributor";
	}

}

package com.denlex.superoptimum.controller;

import com.denlex.superoptimum.domain.product.Category;
import com.denlex.superoptimum.domain.user.Customer;
import com.denlex.superoptimum.domain.user.User;
import com.denlex.superoptimum.dto.UserKind;
import com.denlex.superoptimum.service.product.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Shishkov A.V. on 10.08.18.
 */
@Controller
@RequestMapping(path = "")
public class WelcomeController {

	@Autowired
	private CategoryService categoryService;

	/*@ModelAttribute
	public void addAttributes(Model model) {
		model.addAttribute("userKind", UserKind.DISTRIBUTOR);
	}*/

	@GetMapping(path = {"", "/index"})
	public String showIndexPage(Model model) {
		User user = null;
		model.addAttribute("userKind", user);
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
	public String showLoginPage(Model model) {
		User user = new Customer();
		model.addAttribute("user", user);
		return "login";
	}

	@GetMapping("/optimum_beauty")
	public String showMainPage(@ModelAttribute("user") Customer user, Model model) {
		List<Category> categories = categoryService.findAll();
		model.addAttribute("categories", categories);
		return "optimum_beauty";
	}

}

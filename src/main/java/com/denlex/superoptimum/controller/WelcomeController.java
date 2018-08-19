package com.denlex.superoptimum.controller;

import com.denlex.superoptimum.domain.product.Category;
import com.denlex.superoptimum.domain.user.User;
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

	@GetMapping(path = {"", "/index"})
	public String showIndexPage() {
		return "index";
	}

	@GetMapping("/optimum_beauty")
	public String showMainPage(@ModelAttribute("user") User user, Model model) {
		List<Category> categories = categoryService.findAll();
		model.addAttribute("categories", categories);
		return "optimum_beauty";
	}

}

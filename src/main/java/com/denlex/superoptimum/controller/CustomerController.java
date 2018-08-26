package com.denlex.superoptimum.controller;

import com.denlex.superoptimum.domain.location.City;
import com.denlex.superoptimum.domain.product.Category;
import com.denlex.superoptimum.domain.product.StoreItem;
import com.denlex.superoptimum.domain.product.Subcategory;
import com.denlex.superoptimum.domain.user.Customer;
import com.denlex.superoptimum.service.product.CategoryService;
import com.denlex.superoptimum.service.product.StoreItemService;
import com.denlex.superoptimum.service.product.SubcategoryService;
import com.denlex.superoptimum.service.user.CustomerService;
import com.denlex.superoptimum.service.user.impl.CustomerCredentialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.List;

/**
 * Created by Shishkov A.V. on 19.08.18.
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private CategoryService categoryService;

	@Autowired
	private SubcategoryService subcategoryService;

	@Autowired
	@Qualifier("customerCredentialsService")
	private CustomerCredentialsService credentialsService;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private StoreItemService storeItemService;

	@GetMapping("/loading")
	public String showLoadingPage() {
		return "customer/loading";
	}

	@GetMapping("/login")
	public String showLoginPage() {
		return "customer/login";
	}

	@GetMapping("/main")
	public String showMainPage(Principal principal, Model model, HttpSession session) {
		List<Category> categories = categoryService.findAll();
		model.addAttribute("categories", categories);

		Customer currentCustomer = customerService.findByUsername(principal.getName());
		model.addAttribute("customer", currentCustomer);
		session.setAttribute("customer", currentCustomer);
		return "customer/main";
	}

	@GetMapping("/products/category/{categoryId}")
	public String showProductsByCategory(@PathVariable Long categoryId, Model model, HttpSession session) {
		Customer customer = (Customer) session.getAttribute("customer");
		model.addAttribute("customer", customer);

		Category category = categoryService.findById(categoryId);
		model.addAttribute("category", category);

		City customerCity = customer.getContact().getAddress().getCity();
		List<StoreItem> storeItems = storeItemService.findAllByCategoryAndCity(categoryId, customerCity.getId());
		model.addAttribute("storeItems", storeItems);

		return "customer/category_products";
	}

	@GetMapping("/products/subcategory/{subcategoryId}")
	public String showProductsBySubcategory(@PathVariable Long subcategoryId, Model model, HttpSession session) {
		Customer customer = (Customer) session.getAttribute("customer");
		model.addAttribute("customer", customer);

		Subcategory subcategory = subcategoryService.findById(subcategoryId);
		model.addAttribute("subcategory", subcategory);

		City customerCity = customer.getContact().getAddress().getCity();
		List<StoreItem> storeItems = storeItemService.findAllBySubcategoryAndCity(subcategoryId, customerCity.getId());
		model.addAttribute("storeItems", storeItems);

		return "customer/subcategory_products";
	}

	@GetMapping("/products/product/{productId}")
	public String showProductDetails(@PathVariable Long productId, Model model, HttpSession session) {
		Customer customer = (Customer) session.getAttribute("customer");
		model.addAttribute("customer", customer);

		StoreItem storeItem = storeItemService.findById(productId);
		model.addAttribute("storeItem", storeItem);
		model.addAttribute("subcategory", storeItem.getProduct().getSubcategory());
		model.addAttribute("category", storeItem.getProduct().getSubcategory().getCategory());

		return "customer/product_details";
	}

	@GetMapping("/cart")
	public String showCart(Model model, HttpSession session) {
		Customer customer = (Customer) session.getAttribute("customer");
		model.addAttribute("customer", customer);

		return "customer/cart";
	}

	private String getUsername() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			String currentUserName = authentication.getName();
			return currentUserName;
		}
		return null;
	}
}

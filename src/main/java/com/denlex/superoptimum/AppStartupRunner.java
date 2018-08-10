package com.denlex.superoptimum;

import com.denlex.superoptimum.domain.Credentials;
import com.denlex.superoptimum.domain.Role;
import com.denlex.superoptimum.domain.location.City;
import com.denlex.superoptimum.domain.location.Country;
import com.denlex.superoptimum.domain.location.Region;
import com.denlex.superoptimum.domain.product.Category;
import com.denlex.superoptimum.domain.product.Product;
import com.denlex.superoptimum.domain.product.Subcategory;
import com.denlex.superoptimum.domain.user.Customer;
import com.denlex.superoptimum.service.location.CountryService;
import com.denlex.superoptimum.service.product.CategoryService;
import com.denlex.superoptimum.service.user.CredentialsService;
import com.denlex.superoptimum.service.user.CustomerService;
import com.denlex.superoptimum.service.user.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * Created by Shishkov A.V. on 07.08.18.
 */
@Component
public class AppStartupRunner implements ApplicationRunner {
	@Autowired
	private RoleService roleService;

	@Autowired
	private CredentialsService credentialsService;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private CountryService countryService;

	@Autowired
	private CategoryService categoryService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		fillLocations();
		fillProducts();
		fillRoles();
//		fillCustomers();
	}

	private void fillLocations() {
		Country russia = new Country("Россия");

		Region kurskRegion = new Region("Курская обл.", 46, russia);
		City kursk = new City("Курск", kurskRegion);
		City jelenzogorsk = new City("Железногорск", kurskRegion);
		kurskRegion.getCities().add(kursk);
		kurskRegion.getCities().add(jelenzogorsk);

		Region belgorodRegion = new Region("Белгородская обл.", 31, russia);
		City belgorod = new City("Белгород", belgorodRegion);
		City stOskol = new City("Ст.Оскол", belgorodRegion);
		belgorodRegion.getCities().add(belgorod);
		belgorodRegion.getCities().add(stOskol);

		Region voronejRegion = new Region("Воронежская обл.", 36, russia);
		City voronej = new City("Воронеж", voronejRegion);
		voronejRegion.getCities().add(voronej);

		russia.getRegions().add(kurskRegion);
		russia.getRegions().add(belgorodRegion);
		russia.getRegions().add(voronejRegion);

		countryService.save(russia);

		Country usa = new Country("США");
		Country ukraine = new Country("Украина");

		countryService.save(usa);
		countryService.save(ukraine);
	}

	private void fillProducts() {
		Category cosmetology = new Category("Косметика");
		Subcategory injection = new Subcategory("Инъекционная", cosmetology);
		Subcategory apparatnaya = new Subcategory("Аппаратная", cosmetology);
		Subcategory haircare = new Subcategory("Уход за волосами", cosmetology);
		Product shavingCream = new Product("Крем для бритья", injection, null, null, 1, 10, LocalDate.now(), null);
		Product faceLasion = new Product("Ласьон для лица", injection, null, null, 1, 5, LocalDate.now(), null);
		injection.getProducts().add(shavingCream);
		injection.getProducts().add(faceLasion);
		cosmetology.getSubcategories().add(injection);
		cosmetology.getSubcategories().add(apparatnaya);
		cosmetology.getSubcategories().add(haircare);

		categoryService.save(cosmetology);
	}

	private void fillRoles() {
		Role admin = new Role("admin");
		Role user = new Role("user");
		roleService.save(admin);
		roleService.save(user);
	}

	private void fillCustomers() {
		Role user = roleService.findByName("user");

		Credentials alexCredentials = new Credentials("alex", "alex", user);
		Customer alex = new Customer("Alex", alexCredentials, null, null, null, null);
		user.getCredentials().add(alexCredentials);
		customerService.save(alex);

		Credentials danielCredentials = new Credentials("daniel", "daniel", user);
		Customer daniel = new Customer("Daniel", danielCredentials, null, null, null, null);
		user.getCredentials().add(danielCredentials);
		customerService.save(daniel);
	}
}

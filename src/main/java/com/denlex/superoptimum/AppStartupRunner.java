package com.denlex.superoptimum;

import com.denlex.superoptimum.domain.Credentials;
import com.denlex.superoptimum.domain.Role;
import com.denlex.superoptimum.domain.location.Address;
import com.denlex.superoptimum.domain.location.City;
import com.denlex.superoptimum.domain.location.Country;
import com.denlex.superoptimum.domain.location.Region;
import com.denlex.superoptimum.domain.product.Category;
import com.denlex.superoptimum.domain.product.Product;
import com.denlex.superoptimum.domain.product.Subcategory;
import com.denlex.superoptimum.domain.user.Contact;
import com.denlex.superoptimum.domain.user.Customer;
import com.denlex.superoptimum.domain.user.Distributor;
import com.denlex.superoptimum.service.location.AddressService;
import com.denlex.superoptimum.service.location.CityService;
import com.denlex.superoptimum.service.location.CountryService;
import com.denlex.superoptimum.service.product.CategoryService;
import com.denlex.superoptimum.service.user.*;
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
	private DistributorService distributorService;

	@Autowired
	private CountryService countryService;

	@Autowired
	private CityService cityService;

	@Autowired
	private AddressService addressService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private ContactService contactService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		initAll();
	}

	private void initAll() {
		fillLocations();
		fillProducts();
		fillRoles();
		fillCustomers();
		fillDistributors();
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

		Subcategory injection = new Subcategory("Инъекционная");
		injection.addProduct(
				new Product("Крем для бритья", null, null, 1, 10, LocalDate.now(), null));
		injection.addProduct(
				new Product("Ласьон для лица", null, null, 1, 5, LocalDate.now(), null));

		cosmetology.addSubcategory(injection);
		cosmetology.addSubcategory(new Subcategory("Аппаратная"));
		cosmetology.addSubcategory(new Subcategory("Уход за волосами"));
		categoryService.save(cosmetology);

		Category depilation = new Category("Депиляция");
		depilation.addSubcategory(new Subcategory("Депиряций"));
		categoryService.save(depilation);

		Category solar = new Category("Солярий");
		solar.addSubcategory(new Subcategory("Солярий"));
		categoryService.save(solar);

		Category massage = new Category("Массаж");
		massage.addSubcategory(new Subcategory("Массаж"));
		categoryService.save(massage);

		Category barbershop = new Category("Парикмахерская продукция");
		barbershop.addSubcategory(new Subcategory("Стайлинг"));
		barbershop.addSubcategory(new Subcategory("Наращивание волос"));
		barbershop.addSubcategory(new Subcategory("Инструменты, аксесуары и расходные материалы"));
		categoryService.save(barbershop);

		Category nails = new Category("Ногтевой сервис");
		nails.addSubcategory(new Subcategory("Моделирование"));
		nails.addSubcategory(new Subcategory("Уход за ногтями и кожей рук"));
		nails.addSubcategory(new Subcategory("Декор ногтей"));
		nails.addSubcategory(new Subcategory("Инструменты и техника"));
		nails.addSubcategory(new Subcategory("Расходные материалы"));
		categoryService.save(nails);

		Category eyelashbrow = new Category("Ресницы и брови");
		eyelashbrow.addSubcategory(new Subcategory("Оформление бровей"));
		eyelashbrow.addSubcategory(new Subcategory("Наращивание ресниц"));
		eyelashbrow.addSubcategory(new Subcategory("Ламинирование ресниц"));
		eyelashbrow.addSubcategory(new Subcategory("Микропигментирование"));
		eyelashbrow.addSubcategory(new Subcategory("Инструменты и расходные материалы"));
		categoryService.save(eyelashbrow);

		Category makeup = new Category("Визаж");
		makeup.addSubcategory(new Subcategory("Макияж лица"));
		makeup.addSubcategory(new Subcategory("Макияж глаз"));
		makeup.addSubcategory(new Subcategory("Макияж губ"));
		makeup.addSubcategory(new Subcategory("Кисти для Макияжа"));
		makeup.addSubcategory(new Subcategory("Кейсы и палитра"));
		makeup.addSubcategory(new Subcategory("Инструменты"));
		categoryService.save(makeup);

		Category tattooAndPiercing = new Category("Татуаж и пирсинг");
		tattooAndPiercing.addSubcategory(new Subcategory("Татуаж"));
		tattooAndPiercing.addSubcategory(new Subcategory("Пирсинг"));
		categoryService.save(tattooAndPiercing);

		Category staff = new Category("Расходные материалы и одноразовые принадлежности");
		staff.addSubcategory(new Subcategory("Одноразовые простыни,полотенца, салфетки"));
		staff.addSubcategory(new Subcategory("Одноразовая одежда и перчатки"));
		staff.addSubcategory(new Subcategory("Кисти, шпатели, баночки"));
		staff.addSubcategory(new Subcategory("Ватные диски, спонжи"));
		staff.addSubcategory(new Subcategory("Другое"));
		categoryService.save(staff);

		Category sterilization = new Category("Стерилизация и дезинфекция");
		sterilization.addSubcategory(new Subcategory("Средства для обработки кожи"));
		sterilization.addSubcategory(new Subcategory("Средства для обработки инструментов и поверхностей"));
		sterilization.addSubcategory(new Subcategory("Стерилизаторы, принадлежности и расходники"));
		categoryService.save(sterilization);
	}

	private void fillRoles() {
		Role admin = new Role("ROLE_ADMIN");
		Role user = new Role("ROLE_USER");
		roleService.save(admin);
		roleService.save(user);
	}

	private void fillCustomers() {
		Role user = roleService.findByName("ROLE_USER");

		Credentials alexCredentials = new Credentials("alex", "alex");
		user.addCredentials(alexCredentials);
		alexCredentials.addRole(user);
		alexCredentials = credentialsService.save(alexCredentials);

		Credentials danielCredentials = new Credentials("daniel", "daniel");
		user.addCredentials(danielCredentials);
		danielCredentials.addRole(user);
		danielCredentials = credentialsService.save(danielCredentials);

		Customer alex = new Customer("Alex", alexCredentials, null, null, null, null);
		customerService.save(alex);

		Customer daniel = new Customer("Daniel", danielCredentials, null, null, null, null);
		customerService.save(daniel);
	}

	private void fillDistributors() {
		Role user = roleService.findByName("ROLE_USER");
		Credentials appleCredentials = new Credentials("apple", "apple");
		user.addCredentials(appleCredentials);
		appleCredentials = credentialsService.save(appleCredentials);

		City kursk = cityService.findByName("Курск");
		Address appleAddress = addressService.save(new Address(kursk, "Ленина", "10", null, "305045"));

		Distributor apple = new Distributor(appleCredentials,
				contactService.save(new Contact(appleAddress, "45-54-33", "kursk@apple.com")),
				appleAddress, null, null, "Apple Co");
		distributorService.save(apple);
	}
}

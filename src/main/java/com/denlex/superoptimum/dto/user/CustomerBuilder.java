package com.denlex.superoptimum.dto.user;

import com.denlex.superoptimum.domain.Credentials;
import com.denlex.superoptimum.domain.Role;
import com.denlex.superoptimum.domain.user.Customer;
import com.denlex.superoptimum.service.location.CityService;
import com.denlex.superoptimum.service.user.ContactService;
import com.denlex.superoptimum.service.user.CredentialsService;
import com.denlex.superoptimum.service.user.RoleService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Shishkov A.V. on 08.08.18.
 */
public class CustomerBuilder {
	@Autowired
	private CityService cityService;

	@Autowired
	private ContactService contactService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private CredentialsService credentialsService;

	private String name;

	private String login;
	private String password;

	private String city;

	private String street;
	private String houseNumber;
	private String flatNumber;
	private String postCode;
	private String phoneNumber;
	private String email;

	private Customer customer;

	public CustomerBuilder() {
		this.customer = new Customer();
	}

	public CustomerBuilder setName(String name) {
		this.name = name;
		return this;
	}

	public CustomerBuilder setLoginAndPassword(String login, String password) {
		if (credentialsService.findByLogin(login) != null)
			throw new ArithmeticException(
					"Пользователь с логином (" + login + ") уже существует");

		Role user = roleService.findByName("user");

		if (user == null) {
			user = roleService.save(new Role("user"));
		}

		customer.setCredentials(credentialsService.save(new Credentials(login, password, user)));
		return this;
	}

	public CustomerBuilder setCity(String city) {
		this.city = city;
		return this;
	}

	public CustomerBuilder setStreet(String street) {
		this.street = street;
		return this;
	}

	public CustomerBuilder setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
		return this;
	}

	public CustomerBuilder setFlatNumber(String flatNumber) {
		this.flatNumber = flatNumber;
		return this;
	}

	public CustomerBuilder setPostCode(String postCode) {
		this.postCode = postCode;
		return this;
	}

	public CustomerBuilder setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
		return this;
	}

	public CustomerBuilder setEmail(String email) {
		this.email = email;
		return this;
	}

	public CustomerBuilder setCustomer(Customer customer) {
		this.customer = customer;
		return this;
	}

	public CustomerBuilder buildName(String name) {
		customer.setName(name);
		return this;
	}

	public CustomerBuilder buildLogin(String login) {
		if (customer.getCredentials() == null) {
			customer.setCredentials(new Credentials());
		}
		Credentials credentials = customer.getCredentials();
		credentials.setLogin(login);
		return this;
	}

	public CustomerBuilder buildPassword(String password) {
		if (customer.getCredentials() == null) {
			customer.setCredentials(new Credentials());
		}
		Credentials credentials = customer.getCredentials();
		credentials.setPassword(password);
		return this;
	}

	public Customer build() {
		return customer;
	}
}

package com.denlex.superoptimum.domain.user;

import com.denlex.superoptimum.domain.Credentials;
import com.denlex.superoptimum.domain.location.Address;
import com.denlex.superoptimum.domain.product.Cart;
import com.denlex.superoptimum.domain.product.Order;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Shishkov A.V. on 06.08.18.
 */
@Entity
public class Customer extends User {
	@Column
	private String name;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customer", orphanRemoval = true)
	private Set<Cart> carts = new HashSet<>();

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customer", orphanRemoval = true)
	private Set<Order> orders = new HashSet<>();

	public Customer() {
	}

	public Customer(String name, Credentials credentials, Contact contact, Address address, String orgn, String inn) {
		super(credentials, contact, orgn, inn);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Cart> getCarts() {
		return carts;
	}

	public void setCarts(Set<Cart> carts) {
		this.carts = carts;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
}

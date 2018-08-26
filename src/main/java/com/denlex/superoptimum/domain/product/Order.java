package com.denlex.superoptimum.domain.product;

import com.denlex.superoptimum.domain.BaseEntity;
import com.denlex.superoptimum.domain.user.Customer;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Shishkov A.V. on 07.08.18.
 */
@Entity
@Table(name = "simple_order")
public class Order extends BaseEntity {
	@Column
	private LocalDateTime registrationTime;

	@ManyToOne
	private Customer customer;

	@Column
	private OrderStatus status;

	@OneToMany
	private Set<CartItem> cartItems = new HashSet<>();

	public Order() {
	}

	public Order(LocalDateTime registrationTime, Customer customer, OrderStatus status) {
		this.registrationTime = registrationTime;
		this.customer = customer;
		this.status = status;
	}

	public LocalDateTime getRegistrationTime() {
		return registrationTime;
	}

	public void setRegistrationTime(LocalDateTime registrationTime) {
		this.registrationTime = registrationTime;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Set<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(Set<CartItem> cartItems) {
		this.cartItems = cartItems;
	}
}

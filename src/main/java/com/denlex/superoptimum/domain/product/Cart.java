package com.denlex.superoptimum.domain.product;

import com.denlex.superoptimum.domain.BaseEntity;
import com.denlex.superoptimum.domain.user.Customer;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

/**
 * Created by Shishkov A.V. on 07.08.18.
 */
@Entity
public class Cart extends BaseEntity {
	@ManyToOne
	private Customer customer;

	@Enumerated
	private CartStatus status;

	public Cart() {
	}

	public Cart(Customer customer, CartStatus status) {
		this.customer = customer;
		this.status = status;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public CartStatus getStatus() {
		return status;
	}

	public void setStatus(CartStatus status) {
		this.status = status;
	}
}

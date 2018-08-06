package com.denlex.superoptimum.domain.product;

import com.denlex.superoptimum.domain.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * Created by Shishkov A.V. on 07.08.18.
 */
@Entity
public class ProductItem extends BaseEntity {
	@OneToOne
	private Product product;

	@Column
	private Double quantity;

	@ManyToOne
	private Cart cart;

	public ProductItem() {
	}

	public ProductItem(Product product, Double quantity, Cart cart) {
		this.product = product;
		this.quantity = quantity;
		this.cart = cart;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}
}

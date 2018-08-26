package com.denlex.superoptimum.domain.product;

import com.denlex.superoptimum.domain.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * Created by Shishkov A.V. on 24.08.18.
 */
@Entity
public class StoreItem extends BaseEntity {
	@OneToOne
	private Product product;

	@Column
	private double price;

	@Column
	private double balance;

	@Column
	private int minOrder;

	@Column
	private int maxOrder;

	@ManyToOne
	private Store store;

	public StoreItem() {
	}

	public StoreItem(Product product, double price, double balance, int minOrder, int maxOrder, Store store) {
		this.product = product;
		this.price = price;
		this.balance = balance;
		this.minOrder = minOrder;
		this.maxOrder = maxOrder;
		this.store = store;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public int getMinOrder() {
		return minOrder;
	}

	public void setMinOrder(int minOrder) {
		this.minOrder = minOrder;
	}

	public int getMaxOrder() {
		return maxOrder;
	}

	public void setMaxOrder(int maxOrder) {
		this.maxOrder = maxOrder;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}
}

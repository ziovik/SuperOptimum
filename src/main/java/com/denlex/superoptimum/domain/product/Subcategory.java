package com.denlex.superoptimum.domain.product;

import com.denlex.superoptimum.domain.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.HashSet;

/**
 * Created by Shishkov A.V. on 07.08.18.
 */
@Entity
public class Subcategory extends BaseEntity {
	@Column
	private String name;

	@ManyToOne
	private Category category;

	@OneToMany
	private HashSet<Product> products = new HashSet<>();

	public Subcategory() {
	}

	public Subcategory(String name, Category category) {
		this.name = name;
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public HashSet<Product> getProducts() {
		return products;
	}

	public void setProducts(HashSet<Product> products) {
		this.products = products;
	}
}

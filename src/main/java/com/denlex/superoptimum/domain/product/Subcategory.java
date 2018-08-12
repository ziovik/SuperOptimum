package com.denlex.superoptimum.domain.product;

import com.denlex.superoptimum.domain.BaseEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Shishkov A.V. on 07.08.18.
 */
@Entity
public class Subcategory extends BaseEntity {
	@Column
	private String name;

	@ManyToOne
	private Category category;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "subcategory")
	private Set<Product> products = new HashSet<>();

	public Subcategory() {
	}

	public Subcategory(String name) {
		this.name = name;
	}

	public Subcategory(String name, Category category) {
		this(name);
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

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public void addProduct(Product product) {
		product.setSubcategory(this);
		this.getProducts().add(product);
	}
}

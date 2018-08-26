package com.denlex.superoptimum.domain.product;

import com.denlex.superoptimum.domain.BaseEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Shishkov A.V. on 07.08.18.
 */
@Entity
public class Category extends BaseEntity {
	@Column
	private String name;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category", orphanRemoval = true, fetch = FetchType.EAGER)
	private Set<Subcategory> subcategories = new HashSet<>();

	public Category() {
	}

	public Category(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category(String name, HashSet<Subcategory> subcategories) {
		this.name = name;
		this.subcategories = subcategories;
	}

	public Set<Subcategory> getSubcategories() {
		return subcategories;
	}

	public void setSubcategories(Set<Subcategory> subcategories) {
		this.subcategories = subcategories;
	}

	public void addSubcategory(Subcategory subcategory) {
		subcategory.setCategory(this);
		this.getSubcategories().add(subcategory);
	}

	public void addSubcategories(Subcategory ... subcategories) {
		for (Subcategory subcategory : subcategories) {
			addSubcategory(subcategory);
		}
	}

	@Override
	public String toString() {
		return name;
	}
}

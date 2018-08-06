package com.denlex.superoptimum.domain.product;

import com.denlex.superoptimum.domain.BaseEntity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;

/**
 * Created by Shishkov A.V. on 07.08.18.
 */
@Entity
public class Category extends BaseEntity {
	@Column
	private String name;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category", orphanRemoval = true)
	private HashSet<Subcategory> subcategories = new HashSet<>();

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
}

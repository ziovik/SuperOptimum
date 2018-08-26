package com.denlex.superoptimum.domain.product;

import com.denlex.superoptimum.domain.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

/**
 * Created by Shishkov A.V. on 07.08.18.
 */
@Entity
public class Product extends BaseEntity {
	@Column
	private String name;

	@ManyToOne
	private Subcategory subcategory;

	@Column
	private String manufacturer;

	@Column
	private String description;

	@Column
	private LocalDate expiringDate;

	@Column
	private String keyword;

	public Product() {
	}

	public Product(Subcategory subcategory, String name) {
		this.subcategory = subcategory;
		this.name = name;
	}

	public Product(Subcategory subcategory, String name, String description) {
		this(subcategory, name);
		this.description =  description;
	}

	public Product(Subcategory subcategory, String name, String description, String keyword) {
		this(subcategory, name, description);
		this.keyword = keyword;
	}

	public Product(Subcategory subcategory, String name, String description, String keyword, String manufacturer, LocalDate expiringDate) {
		this(subcategory, name, description, keyword);
		this.manufacturer = manufacturer;
		this.expiringDate = expiringDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Subcategory getSubcategory() {
		return subcategory;
	}

	public void setSubcategory(Subcategory subcategory) {
		this.subcategory = subcategory;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getExpiringDate() {
		return expiringDate;
	}

	public void setExpiringDate(LocalDate expiringDate) {
		this.expiringDate = expiringDate;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
}

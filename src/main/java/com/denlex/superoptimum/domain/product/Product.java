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
	private Integer minOrder;

	@Column
	private Integer maxOrder;

	@Column
	private LocalDate expiringDate;

	@Column
	private String keyword;

	public Product() {
	}

	public Product(String name, String manufacturer, String description, Integer minOrder, Integer maxOrder, LocalDate expiringDate, String keyword) {
		this.name = name;
		this.manufacturer = manufacturer;
		this.description = description;
		this.minOrder = minOrder;
		this.maxOrder = maxOrder;
		this.expiringDate = expiringDate;
		this.keyword = keyword;
	}

	public Product(String name, Subcategory subcategory, String manufacturer, String description, Integer minOrder, Integer maxOrder, LocalDate expiringDate, String keyword) {
		this(name, manufacturer, description, minOrder, maxOrder, expiringDate, keyword);
		this.subcategory = subcategory;
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

	public Integer getMinOrder() {
		return minOrder;
	}

	public void setMinOrder(Integer minOrder) {
		this.minOrder = minOrder;
	}

	public Integer getMaxOrder() {
		return maxOrder;
	}

	public void setMaxOrder(Integer maxOrder) {
		this.maxOrder = maxOrder;
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

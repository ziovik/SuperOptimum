package com.denlex.superoptimum.domain.product;

import com.denlex.superoptimum.domain.BaseEntity;
import com.denlex.superoptimum.domain.location.City;
import com.denlex.superoptimum.domain.user.Distributor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Shishkov A.V. on 07.08.18.
 */
@Entity
public class Store extends BaseEntity {

	@OneToOne
	private City city;

	@OneToMany
	private Set<ProductItem> products = new HashSet<>();

	@ManyToOne
	private Distributor distributor;

	public Store() {
	}

	public Store(City city, Distributor distributor) {
		this.city = city;
		this.distributor = distributor;
	}

	public Store(City city, Set<ProductItem> products, Distributor distributor) {
		this.city = city;
		this.products = products;
		this.distributor = distributor;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Set<ProductItem> getProducts() {
		return products;
	}

	public void setProducts(Set<ProductItem> products) {
		this.products = products;
	}

	public Distributor getDistributor() {
		return distributor;
	}

	public void setDistributor(Distributor distributor) {
		this.distributor = distributor;
	}

	public void addProduct(Product product) {

	}
}

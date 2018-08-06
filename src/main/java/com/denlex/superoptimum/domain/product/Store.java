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
	private Set<Product> products = new HashSet<Product>();

	@ManyToOne
	private Distributor distributor;

	public Store() {
	}

	public Store(City city, Distributor distributor) {
		this.city = city;
		this.distributor = distributor;
	}

	public Store(City city, Set<Product> products, Distributor distributor) {
		this.city = city;
		this.products = products;
		this.distributor = distributor;
	}
}

package com.denlex.superoptimum.domain.user;

import com.denlex.superoptimum.domain.product.Store;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Shishkov A.V. on 07.08.18.
 */
@Entity
public class Distributor extends User {
	@Column
	private String companyName;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "distributor", orphanRemoval = true)
	private Set<Store> stores = new HashSet<>();

	public Distributor() {
	}

	public Distributor(Credentials credentials, Contact contact, String orgn, String inn, String companyName) {
		super(credentials, contact, orgn, inn);
		this.companyName = companyName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Set<Store> getStores() {
		return stores;
	}

	public void setStores(Set<Store> stores) {
		this.stores = stores;
	}

	public void addStore(Store store) {
		store.setDistributor(this);
		this.getStores().add(store);
	}
}

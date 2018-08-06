package com.denlex.superoptimum.domain.location;

import com.denlex.superoptimum.domain.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Created by Shishkov A.V. on 06.08.18.
 */
@Entity
public class Address extends BaseEntity {
	@ManyToOne
	private City city;

	@Column
	private String street;

	@Column
	private String houseNumber;

	@Column
	private String flatNumber;

	@Column
	private String postCode;

	public Address() {
	}

	public Address(City city, String street, String houseNumber, String flatNumber, String postCode) {
		this.city = city;
		this.street = street;
		this.houseNumber = houseNumber;
		this.flatNumber = flatNumber;
		this.postCode = postCode;
	}
}

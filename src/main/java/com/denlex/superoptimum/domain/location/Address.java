package com.denlex.superoptimum.domain.location;

import com.denlex.superoptimum.domain.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Created by Shishkov A.V. on 06.08.18.
 */
@Entity
public class Address extends BaseEntity {
	@ManyToOne
	private City city;
	private String street;
	private String houseNumber;
	private String flatNumber;
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

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getFlatNumber() {
		return flatNumber;
	}

	public void setFlatNumber(String flatNumber) {
		this.flatNumber = flatNumber;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
}

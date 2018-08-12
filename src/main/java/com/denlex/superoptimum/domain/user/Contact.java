package com.denlex.superoptimum.domain.user;

import com.denlex.superoptimum.domain.BaseEntity;
import com.denlex.superoptimum.domain.location.Address;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;

/**
 * Created by Shishkov A.V. on 07.08.18.
 */
@Entity
public class Contact extends BaseEntity {

	@OneToOne
	private Address address;

	@Column
	private String phoneNumber;

	@Email
	@Column
	private String email;

	public Contact() {
	}

	public Contact(Address address, String phoneNumber, @Email String email) {
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}

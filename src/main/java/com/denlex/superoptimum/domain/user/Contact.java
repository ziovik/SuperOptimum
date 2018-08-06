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
}

package com.denlex.superoptimum.domain.user;

import com.denlex.superoptimum.domain.BaseEntity;
import com.denlex.superoptimum.domain.Credentials;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

/**
 * Created by Shishkov A.V. on 06.08.18.
 */
@MappedSuperclass
public abstract class User extends BaseEntity {
	@OneToOne
	private Credentials credentials;

	@OneToOne
	private Contact contact;

	@Column
	private String orgn;

	@Column
	private String inn;

	public User() {
	}

	public User(Credentials credentials, Contact contact, String orgn, String inn) {
		this.credentials = credentials;
		this.contact = contact;
		this.orgn = orgn;
		this.inn = inn;
	}

	public Credentials getCredentials() {
		return credentials;
	}

	public void setCredentials(Credentials credentials) {
		this.credentials = credentials;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public String getOrgn() {
		return orgn;
	}

	public void setOrgn(String orgn) {
		this.orgn = orgn;
	}

	public String getInn() {
		return inn;
	}

	public void setInn(String inn) {
		this.inn = inn;
	}
}

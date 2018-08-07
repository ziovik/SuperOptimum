package com.denlex.superoptimum.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Shishkov A.V. on 06.08.18.
 */
@Entity
public class Role extends BaseEntity {

	@Column
	String name;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "role", orphanRemoval = true)
	private Set<Credentials> credentials = new HashSet<>();

	public Role() {
	}

	public Role(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Credentials> getCredentials() {
		return credentials;
	}

	public void setCredentials(Set<Credentials> credentials) {
		this.credentials = credentials;
	}
}

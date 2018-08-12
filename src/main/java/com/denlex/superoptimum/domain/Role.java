package com.denlex.superoptimum.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Shishkov A.V. on 06.08.18.
 */
@Entity
public class Role extends BaseEntity {
	private String name;

	@ManyToMany(mappedBy = "roles", fetch = FetchType.EAGER)
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

	public void addCredentials(Credentials credentials) {
		this.getCredentials().add(credentials);
	}
}

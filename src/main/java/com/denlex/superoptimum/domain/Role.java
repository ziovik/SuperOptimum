package com.denlex.superoptimum.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by Shishkov A.V. on 06.08.18.
 */
@Entity
public class Role extends BaseEntity {
	@Column
	private String name;

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
}

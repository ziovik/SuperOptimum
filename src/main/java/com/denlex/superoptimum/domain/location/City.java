package com.denlex.superoptimum.domain.location;

import com.denlex.superoptimum.domain.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Created by Shishkov A.V. on 07.08.18.
 */
@Entity
public class City extends BaseEntity {
	@Column
	private String name;

	@ManyToOne
	private Region region;

	public City() {
	}

	public City(String name, Region region) {
		this.name = name;
		this.region = region;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}
}

package com.denlex.superoptimum.domain.location;

import com.denlex.superoptimum.domain.BaseEntity;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Shishkov A.V. on 06.08.18.
 */
@Entity
public class Country extends BaseEntity {

	@Column
	private String name;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "country", orphanRemoval = true)
	@JsonManagedReference
	private Set<Region> regions = new HashSet<>();

	public Country() {
	}

	public Country(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Region> getRegions() {
		return regions;
	}

	public void setRegions(Set<Region> regions) {
		this.regions = regions;
	}

	public void addRegion(Region region) {
		region.setCountry(this);
		this.getRegions().add(region);
	}

	public void addRegions(Region ... regions) {
		for (Region region : regions) {
			addRegion(region);
		}
	}
}

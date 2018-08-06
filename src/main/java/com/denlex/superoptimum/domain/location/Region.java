package com.denlex.superoptimum.domain.location;

import com.denlex.superoptimum.domain.BaseEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Shishkov A.V. on 06.08.18.
 */
@Entity
public class Region extends BaseEntity {

	@Column
	private String name;

	@Column
	private Integer code;

	@ManyToOne
	@JsonBackReference
	private Country country;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "region", orphanRemoval = true)
	private Set<City> cities = new HashSet<>();

	public Region() {
	}

	public Region(String name, Integer code, Country country) {
		this.name = name;
		this.code = code;
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Set<City> getCities() {
		return cities;
	}

	public void setCities(Set<City> cities) {
		this.cities = cities;
	}
}

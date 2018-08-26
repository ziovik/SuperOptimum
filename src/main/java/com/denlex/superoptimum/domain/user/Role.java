package com.denlex.superoptimum.domain.user;

import com.denlex.superoptimum.domain.BaseEntity;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.Transient;

/**
 * Created by Shishkov A.V. on 06.08.18.
 */
@Entity
public class Role extends BaseEntity implements GrantedAuthority {
	@Transient
	private final String prefix = "ROLE_";

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

	@Override
	public String getAuthority() {
		return prefix + name;
	}
}

package com.denlex.superoptimum.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Created by Shishkov A.V. on 06.08.18.
 */
@Entity
public class Credentials extends BaseEntity {
	@Column
	private String login;

	@Column
	private String password;

	@ManyToOne
	private Role role;

	public Credentials() {
	}

	public Credentials(String login, String password, Role role) {
		this.login = login;
		this.password = password;
		this.role = role;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}

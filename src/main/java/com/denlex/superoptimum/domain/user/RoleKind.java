package com.denlex.superoptimum.domain.user;

/**
 * Created by Shishkov A.V. on 18.08.18.
 */
public enum RoleKind {
	CUSTOMER("CUSTOMER"), DISTRIBUTOR("DISTRIBUTOR"), ADMIN("ADMIN");

	private String value;

	RoleKind(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}

package com.denlex.superoptimum.dto;

/**
 * Created by Shishkov A.V. on 10.08.18.
 */
public enum UserKind {
	UNDEFINED(0), CUSTOMER(1), DISTRIBUTOR(2);

	private final int value;

	UserKind(int value) {
		this.value = value;
	}
}

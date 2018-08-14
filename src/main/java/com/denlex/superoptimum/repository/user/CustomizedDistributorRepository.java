package com.denlex.superoptimum.repository.user;

import com.denlex.superoptimum.domain.Credentials;

/**
 * Created by Shishkov A.V. on 14.08.18.
 */
public interface CustomizedDistributorRepository {
	Credentials findCredentialsByUsername(String username);
}

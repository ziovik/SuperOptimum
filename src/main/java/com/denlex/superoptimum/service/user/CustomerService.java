package com.denlex.superoptimum.service.user;

import com.denlex.superoptimum.domain.Credentials;
import com.denlex.superoptimum.domain.user.Customer;

/**
 * Created by Shishkov A.V. on 08.08.18.
 */
public interface CustomerService {
	Customer save(Customer customer);

	Credentials findCredentialsByUsername(String username);
}

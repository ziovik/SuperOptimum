package com.denlex.superoptimum.service.user;

import com.denlex.superoptimum.domain.Credentials;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Created by Shishkov A.V. on 08.08.18.
 */
public interface CredentialsService extends UserDetailsService {
	Credentials save(Credentials credentials);

	Credentials findByUsername(String username);
}

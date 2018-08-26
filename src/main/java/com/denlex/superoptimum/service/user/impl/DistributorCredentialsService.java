package com.denlex.superoptimum.service.user.impl;

import com.denlex.superoptimum.domain.user.Credentials;
import com.denlex.superoptimum.service.user.CredentialsServiceBase;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by Shishkov A.V. on 19.08.18.
 */
@Service
public class DistributorCredentialsService extends CredentialsServiceBase {
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return findByUsername(username);
	}

	@Override
	public Credentials findByUsername(String username) {
		Credentials credentials = credentialsRepository.findDistributorCredentialsByUsername(username);

		if (credentials == null)
			throw new UsernameNotFoundException("Пользователеь с логином " + username + " не найден");

		return credentials;
	}
}

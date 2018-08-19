package com.denlex.superoptimum.service.user.security;

import com.denlex.superoptimum.domain.user.Credentials;
import com.denlex.superoptimum.repository.user.CredentialsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by Shishkov A.V. on 18.08.18.
 */
@Service
public class CustomerCredentialsService implements UserDetailsService {
	@Autowired
	private CredentialsRepository credentialsRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Credentials credentials = credentialsRepository.findCustomerCredentialsByUsername(username);

		if (credentials == null)
			throw new UsernameNotFoundException("Пользователеь с логином " + username + " не найден");

		return credentials;
	}
}

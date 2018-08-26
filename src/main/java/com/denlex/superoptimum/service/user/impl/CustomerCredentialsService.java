package com.denlex.superoptimum.service.user.impl;

import com.denlex.superoptimum.domain.user.Credentials;
import com.denlex.superoptimum.domain.user.Role;
import com.denlex.superoptimum.repository.user.RoleRepository;
import com.denlex.superoptimum.service.user.CredentialsServiceBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by Shishkov A.V. on 18.08.18.
 */
@Service
public class CustomerCredentialsService extends CredentialsServiceBase {
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return findByUsername(username);
	}

	@Override
	public Credentials findByUsername(String username) {
		Credentials credentials = credentialsRepository.findCustomerCredentialsByUsername(username);

//		credentials.setPassword(bCryptPasswordEncoder.encode(credentials.getPassword()));
		Role role = roleRepository.findByName("CUSTOMER");
		credentials.addRole(role);

		if (credentials == null)
			throw new UsernameNotFoundException("Пользователеь с логином " + username + " не найден");

		return credentials;
	}
}

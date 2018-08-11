package com.denlex.superoptimum.service.user.impl;

import com.denlex.superoptimum.domain.Credentials;
import com.denlex.superoptimum.domain.Role;
import com.denlex.superoptimum.repository.user.CredentialsRepository;
import com.denlex.superoptimum.repository.user.RoleRepository;
import com.denlex.superoptimum.service.user.CredentialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Shishkov A.V. on 08.08.18.
 */
@Service
@Transactional
public class CredentialsServiceImpl implements CredentialsService {
	@Autowired
	private CredentialsRepository credentialsRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public Credentials save(Credentials credentials) {
		credentials.setPassword(bCryptPasswordEncoder.encode(credentials.getPassword()));
		return credentialsRepository.save(credentials);
	}

	@Override
	public Credentials findByUsername(String username) {
		return credentialsRepository.findByUsername(username);
	}

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Credentials credentials = credentialsRepository.findByUsername(username);
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

		for (Role role : credentials.getRoles()) {
			grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
		}

		return new org.springframework.security.core.userdetails.User(credentials.getUsername(), credentials.getPassword(), grantedAuthorities);
	}
}

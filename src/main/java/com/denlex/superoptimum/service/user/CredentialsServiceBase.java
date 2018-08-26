package com.denlex.superoptimum.service.user;

import com.denlex.superoptimum.domain.user.Credentials;
import com.denlex.superoptimum.repository.user.CredentialsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by Shishkov A.V. on 08.08.18.
 */
public abstract class CredentialsServiceBase implements CredentialsService, UserDetailsService {
	@Autowired
	protected CredentialsRepository credentialsRepository;

	@Autowired
	protected BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public Credentials save(Credentials credentials) {
		credentials.setPassword(bCryptPasswordEncoder.encode(credentials.getPassword()));
		return credentialsRepository.save(credentials);
	}
}

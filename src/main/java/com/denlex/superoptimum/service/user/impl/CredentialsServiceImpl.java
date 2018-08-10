package com.denlex.superoptimum.service.user.impl;

import com.denlex.superoptimum.domain.Credentials;
import com.denlex.superoptimum.repository.user.CredentialsRepository;
import com.denlex.superoptimum.service.user.CredentialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
/**
 * Created by Shishkov A.V. on 08.08.18.
 */
@Service
@Transactional
public class CredentialsServiceImpl implements CredentialsService {
	@Autowired
	private CredentialsRepository credentialsRepository;

	@Override
	public Credentials save(Credentials credentials) {
		return credentialsRepository.save(credentials);
	}

	@Override
	public Credentials findByLogin(String login) {
		return credentialsRepository.findByLogin(login);
	}

	@Override
	public List<Credentials> findByPassword(String password) {
		return credentialsRepository.findByPassword(password);
	}
}

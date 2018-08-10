package com.denlex.superoptimum.service.user;

import com.denlex.superoptimum.domain.Credentials;
import java.util.List;

/**
 * Created by Shishkov A.V. on 08.08.18.
 */
public interface CredentialsService {
	Credentials save(Credentials credentials);

	Credentials findByLogin(String login);

	List<Credentials> findByPassword(String password);
}

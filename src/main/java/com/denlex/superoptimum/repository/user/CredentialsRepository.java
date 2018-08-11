package com.denlex.superoptimum.repository.user;

import com.denlex.superoptimum.domain.Credentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Shishkov A.V. on 08.08.18.
 */
@Repository
public interface CredentialsRepository extends JpaRepository<Credentials, Long> {
	Credentials findByUsername(String username);
}

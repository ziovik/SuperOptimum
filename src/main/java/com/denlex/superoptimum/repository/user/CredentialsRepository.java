package com.denlex.superoptimum.repository.user;

import com.denlex.superoptimum.domain.user.Credentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by Shishkov A.V. on 08.08.18.
 */
@Repository
public interface CredentialsRepository extends JpaRepository<Credentials, Long> {
	Credentials findByUsername(String username);

	@Query(value = "select * from super_optimum.credentials cr " +
			"join super_optimum.customer c on cr.id = c.credentials_id " +
			"where cr.username = ?1", nativeQuery = true)
	Credentials findCustomerCredentialsByUsername(String username);

	@Query(value = "select * from super_optimum.credentials cr " +
			"join super_optimum.distributor d on cr.id = d.credentials_id " +
			"where cr.username = ?1", nativeQuery = true)
	Credentials findDistributorCredentialsByUsername(String username);
}

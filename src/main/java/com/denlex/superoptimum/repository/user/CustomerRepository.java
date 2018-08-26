package com.denlex.superoptimum.repository.user;

import com.denlex.superoptimum.domain.user.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by Shishkov A.V. on 06.08.18.
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	@Query(nativeQuery = true, value = "select c.* from super_optimum.customer c " +
			"join super_optimum.credentials cr on c.credentials_id = cr.id " +
			"where cr.username = ?1")
	Customer findByUsername(String username);
}

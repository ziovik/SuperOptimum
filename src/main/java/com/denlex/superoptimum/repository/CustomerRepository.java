package com.denlex.superoptimum.repository;

import com.denlex.superoptimum.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Shishkov A.V. on 06.08.18.
 */
@Repository
public interface CustomerRepository extends JpaRepository<Long, Customer> {
}

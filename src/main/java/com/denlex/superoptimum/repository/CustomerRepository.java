package com.denlex.superoptimum.repository;

import com.denlex.superoptimum.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Shishkov A.V. on 06.08.18.
 */
public interface CustomerRepository extends JpaRepository<Long, Customer> {
}

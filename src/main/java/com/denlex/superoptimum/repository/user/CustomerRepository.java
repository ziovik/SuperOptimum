package com.denlex.superoptimum.repository.user;

import com.denlex.superoptimum.domain.user.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Shishkov A.V. on 06.08.18.
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>, CustomizedCustomerRepository {
}

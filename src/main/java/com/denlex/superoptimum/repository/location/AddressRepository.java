package com.denlex.superoptimum.repository.location;

import com.denlex.superoptimum.domain.location.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Shishkov A.V. on 09.08.18.
 */
@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}

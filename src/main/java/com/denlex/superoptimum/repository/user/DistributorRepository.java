package com.denlex.superoptimum.repository.user;

import com.denlex.superoptimum.domain.user.Distributor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Shishkov A.V. on 07.08.18.
 */
@Repository
public interface DistributorRepository extends JpaRepository<Distributor, Long>, CustomizedDistributorRepository {
}

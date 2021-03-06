package com.denlex.superoptimum.repository.location;

import com.denlex.superoptimum.domain.location.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Shishkov A.V. on 07.08.18.
 */
@Repository
public interface RegionRepository extends JpaRepository<Region, Long> {
}

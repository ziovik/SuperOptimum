package com.denlex.superoptimum.repository.location;

import com.denlex.superoptimum.domain.location.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Shishkov A.V. on 07.08.18.
 */
@Repository
public interface CityRepository extends JpaRepository<City, Long> {
	City findByName(String name);
}

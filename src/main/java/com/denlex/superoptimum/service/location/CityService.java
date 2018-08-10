package com.denlex.superoptimum.service.location;

import com.denlex.superoptimum.domain.location.City;
import org.springframework.stereotype.Service;

/**
 * Created by Shishkov A.V. on 07.08.18.
 */
@Service
public interface CityService {
	City save(City city);

	City findByName(String name);
}

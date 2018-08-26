package com.denlex.superoptimum.service.location;

import com.denlex.superoptimum.domain.location.Country;

/**
 * Created by Shishkov A.V. on 07.08.18.
 */
public interface CountryService {
	Country save(Country country);

	Country findByName(String name);
}

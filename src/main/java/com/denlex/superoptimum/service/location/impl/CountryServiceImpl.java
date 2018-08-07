package com.denlex.superoptimum.service.location.impl;

import com.denlex.superoptimum.domain.location.Country;
import com.denlex.superoptimum.repository.location.CountryRepository;
import com.denlex.superoptimum.service.location.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Shishkov A.V. on 07.08.18.
 */
@Service
@Transactional
public class CountryServiceImpl implements CountryService {
	@Autowired
	private CountryRepository countryRepository;

	@Override
	public Country save(Country country) {
		return countryRepository.save(country);
	}
}

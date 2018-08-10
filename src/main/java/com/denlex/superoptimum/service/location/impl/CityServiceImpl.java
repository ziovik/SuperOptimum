package com.denlex.superoptimum.service.location.impl;

import com.denlex.superoptimum.domain.location.City;
import com.denlex.superoptimum.repository.location.CityRepository;
import com.denlex.superoptimum.service.location.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Shishkov A.V. on 07.08.18.
 */

@Service
@Transactional
public class CityServiceImpl implements CityService {
	@Autowired
	private CityRepository cityRepository;

	@Override
	public City save(City city) {
		return cityRepository.save(city);
	}

	@Override
	public City findByName(String name) {
		return cityRepository.findByName(name);
	}
}

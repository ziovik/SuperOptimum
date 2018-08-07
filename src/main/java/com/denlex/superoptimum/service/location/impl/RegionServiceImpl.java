package com.denlex.superoptimum.service.location.impl;

import com.denlex.superoptimum.domain.location.Region;
import com.denlex.superoptimum.repository.location.RegionRepository;
import com.denlex.superoptimum.service.location.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Shishkov A.V. on 07.08.18.
 */
@Service
@Transactional
public class RegionServiceImpl implements RegionService {
	@Autowired
	private RegionRepository regionRepository;
	@Override
	public Region save(Region region) {
		return regionRepository.save(region);
	}
}

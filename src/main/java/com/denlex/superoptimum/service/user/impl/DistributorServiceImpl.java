package com.denlex.superoptimum.service.user.impl;

import com.denlex.superoptimum.domain.user.Distributor;
import com.denlex.superoptimum.repository.user.DistributorRepository;
import com.denlex.superoptimum.service.user.DistributorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Shishkov A.V. on 08.08.18.
 */
@Service
public class DistributorServiceImpl implements DistributorService {
	@Autowired
	private DistributorRepository distributorRepository;

	@Override
	public Distributor save(Distributor distributor) {
		return distributorRepository.save(distributor);
	}
}

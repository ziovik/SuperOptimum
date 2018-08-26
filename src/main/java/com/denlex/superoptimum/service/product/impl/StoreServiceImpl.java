package com.denlex.superoptimum.service.product.impl;

import com.denlex.superoptimum.domain.product.Store;
import com.denlex.superoptimum.repository.product.StoreRepository;
import com.denlex.superoptimum.service.product.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by Shishkov A.V. on 25.08.18.
 */
@Service
public class StoreServiceImpl implements StoreService {
	@Autowired
	private StoreRepository storeRepository;

	@Override
	public List<Store> findAll() {
		return storeRepository.findAll();
	}

	@Override
	public Store findById(Long id) {
		Optional<Store> result = storeRepository.findById(id);
		return result.isPresent() ? result.get() : null;
	}

	@Override
	public List<Store> findStoresByCityId(Long cityId) {
		return storeRepository.findStoresByCity(cityId);
	}

	@Override
	public List<Store> findStoresByRegionId(Long regionId) {
		return storeRepository.findStoresByRegion(regionId);
	}

	@Override
	public void save(Store store) {
		storeRepository.save(store);
	}
}

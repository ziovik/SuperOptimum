package com.denlex.superoptimum.service.product;

import com.denlex.superoptimum.domain.product.Store;

import java.util.List;

/**
 * Created by Shishkov A.V. on 25.08.18.
 */
public interface StoreService {
	List<Store> findAll();

	Store findById(Long id);

	List<Store> findStoresByCityId(Long cityId);

	List<Store> findStoresByRegionId(Long regionId);

	void save(Store store);
}

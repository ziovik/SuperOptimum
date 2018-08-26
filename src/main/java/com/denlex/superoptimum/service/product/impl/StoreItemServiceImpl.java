package com.denlex.superoptimum.service.product.impl;

import com.denlex.superoptimum.domain.product.StoreItem;
import com.denlex.superoptimum.repository.product.StoreItemRepository;
import com.denlex.superoptimum.service.product.StoreItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by Shishkov A.V. on 25.08.18.
 */
@Service
public class StoreItemServiceImpl implements StoreItemService {
	@Autowired
	private StoreItemRepository repository;

	@Override
	public List<StoreItem> findAllByCategory(Long categoryId) {
		return repository.findAllByCategory(categoryId);
	}

	@Override
	public List<StoreItem> findAllByCategoryAndCity(Long categoryId, Long cityId) {
		return repository.findAllByCategoryAndCity(categoryId, cityId);
	}

	@Override
	public List<StoreItem> findAllByCategoryAndRegion(Long categoryId, Long regionId) {
		return repository.findAllByCategoryAndRegion(categoryId, regionId);
	}

	@Override
	public StoreItem findById(Long id) {
		Optional<StoreItem> result = repository.findById(id);
		return result.isPresent() ? result.get() : null;
	}

	@Override
	public List<StoreItem> findAllBySubcategory(Long subcategoryId) {
		return repository.findAllBySubcategory(subcategoryId);
	}

	@Override
	public List<StoreItem> findAllBySubcategoryAndCity(Long subcategoryId, Long cityId) {
		return repository.findAllBySubcategoryAndCity(subcategoryId, cityId);
	}

	@Override
	public List<StoreItem> findAllBySubcategoryAndRegion(Long subcategoryId, Long regionId) {
		return repository.findAllBySubcategoryAndRegion(subcategoryId, regionId);
	}
}

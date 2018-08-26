package com.denlex.superoptimum.service.product.impl;

import com.denlex.superoptimum.domain.product.Subcategory;
import com.denlex.superoptimum.repository.product.SubcategoryRepository;
import com.denlex.superoptimum.service.product.SubcategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by Shishkov A.V. on 07.08.18.
 */
@Service
public class SubcategoryServiceImpl implements SubcategoryService {
	@Autowired
	private SubcategoryRepository repository;

	@Override
	public List<Subcategory> findAll() {
		return repository.findAll();
	}

	@Override
	public Subcategory findById(Long id) {
		Optional<Subcategory> result = repository.findById(id);
		return result.isPresent() ? result.get() : null;
	}

	@Override
	public Subcategory save(Subcategory subcategory) {
		return repository.save(subcategory);
	}
}

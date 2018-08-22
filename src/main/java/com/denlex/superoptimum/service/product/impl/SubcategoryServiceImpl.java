package com.denlex.superoptimum.service.product.impl;

import com.denlex.superoptimum.domain.product.Subcategory;
import com.denlex.superoptimum.repository.product.SubcategoryRepository;
import com.denlex.superoptimum.service.product.SubcategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Shishkov A.V. on 07.08.18.
 */
@Service
public class SubcategoryServiceImpl implements SubcategoryService {
	@Autowired
	private SubcategoryRepository subcategoryRepository;

	@Override
	public List<Subcategory> findAll() {
		return subcategoryRepository.findAll();
	}

	@Override
	public Subcategory save(Subcategory subcategory) {
		return subcategoryRepository.save(subcategory);
	}
}

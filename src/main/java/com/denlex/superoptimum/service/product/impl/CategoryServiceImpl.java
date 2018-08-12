package com.denlex.superoptimum.service.product.impl;

import com.denlex.superoptimum.domain.product.Category;
import com.denlex.superoptimum.repository.product.CategoryRepository;
import com.denlex.superoptimum.service.product.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Shishkov A.V. on 07.08.18.
 */
@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Category save(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}
}

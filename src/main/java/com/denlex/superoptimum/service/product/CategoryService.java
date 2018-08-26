package com.denlex.superoptimum.service.product;

import com.denlex.superoptimum.domain.product.Category;

import java.util.List;

/**
 * Created by Shishkov A.V. on 07.08.18.
 */
public interface CategoryService {
	List<Category> findAll();

	Category findById(Long id);

	Category findByName(String name);

	Category save(Category category);
}

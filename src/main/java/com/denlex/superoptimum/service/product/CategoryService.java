package com.denlex.superoptimum.service.product;

import com.denlex.superoptimum.domain.product.Category;

import java.util.List;

/**
 * Created by Shishkov A.V. on 07.08.18.
 */
public interface CategoryService {
	Category save(Category category);

	List<Category> findAll();
}

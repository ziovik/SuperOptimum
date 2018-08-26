package com.denlex.superoptimum.service.product;

import com.denlex.superoptimum.domain.product.Subcategory;

import java.util.List;

/**
 * Created by Shishkov A.V. on 07.08.18.
 */
public interface SubcategoryService {
	List<Subcategory> findAll();

	Subcategory findById(Long id);

	Subcategory save(Subcategory subcategory);
}

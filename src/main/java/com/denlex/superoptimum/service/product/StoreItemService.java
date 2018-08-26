package com.denlex.superoptimum.service.product;

import com.denlex.superoptimum.domain.product.StoreItem;

import java.util.List;

/**
 * Created by Shishkov A.V. on 25.08.18.
 */
public interface StoreItemService {
	List<StoreItem> findAllByCategory(Long categoryId);

	List<StoreItem> findAllByCategoryAndCity(Long categoryId, Long cityId);

	List<StoreItem> findAllByCategoryAndRegion(Long categoryId, Long regionId);

	StoreItem findById(Long id);

	List<StoreItem> findAllBySubcategory(Long subcategoryId);

	List<StoreItem> findAllBySubcategoryAndCity(Long subcategoryId, Long cityId);

	List<StoreItem> findAllBySubcategoryAndRegion(Long subcategoryId, Long regionId);
}

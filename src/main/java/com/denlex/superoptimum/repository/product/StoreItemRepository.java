package com.denlex.superoptimum.repository.product;

import com.denlex.superoptimum.domain.product.StoreItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Shishkov A.V. on 25.08.18.
 */
@Repository
public interface StoreItemRepository extends JpaRepository<StoreItem, Long> {
	@Query(
			nativeQuery = true,
			value = "select si.* " +
					"from super_optimum.store_item si " +
					"	join super_optimum.product p on si.product_id = p.id " +
					"	join super_optimum.subcategory sub_cat on p.subcategory_id = sub_cat.id " +
					"where sub_cat.category_id = ?1"
	)
	List<StoreItem> findAllByCategory(Long categoryId);

	@Query(
			nativeQuery = true,
			value = "select si.* " +
					"from super_optimum.store_item si " +
					"	join super_optimum.product p on si.product_id = p.id " +
					"	join super_optimum.subcategory sub_cat on p.subcategory_id = sub_cat.id " +
					"	join super_optimum.store st on si.store_id = st.id " +
					"where sub_cat.category_id = ?1 and st.city_id = ?2"
	)
	List<StoreItem> findAllByCategoryAndCity(Long categoryId, Long cityId);

	@Query(
			nativeQuery = true,
			value = "select si.* " +
					"from super_optimum.store_item si " +
					"	join super_optimum.product p on si.product_id = p.id " +
					"	join super_optimum.subcategory sub_cat on p.subcategory_id = sub_cat.id " +
					"	join super_optimum.store st on si.store_id = st.id " +
					"	join super_optimum.city c on st.city_id = c.id " +
					"where sub_cat.category_id = ?1 and c.region_id = ?2"
	)
	List<StoreItem> findAllByCategoryAndRegion(Long categoryId, Long regionId);

	@Query(
			nativeQuery = true,
			value = "select si.* " +
					"from super_optimum.store_item si " +
					"	join super_optimum.product p on si.product_id = p.id " +
					"where p.subcategory_id = ?1"
	)
	List<StoreItem> findAllBySubcategory(Long subcategoryId);

	@Query(
			nativeQuery = true,
			value = "select si.* " +
					"from super_optimum.store_item si " +
					"	join super_optimum.product p on si.product_id = p.id " +
					"	join super_optimum.store st on si.store_id = st.id " +
					"where p.subcategory_id = ?1 and st.city_id = ?2"
	)
	List<StoreItem> findAllBySubcategoryAndCity(Long subcategoryId, Long cityId);

	@Query(
			nativeQuery = true,
			value = "select si.* " +
					"from super_optimum.store_item si " +
					"	join super_optimum.product p on si.product_id = p.id " +
					"	join super_optimum.store st on si.store_id = st.id " +
					"	join super_optimum.city c on st.city_id = c.id " +
					"where p.subcategory_id = ?1 and c.region_id = ?2"
	)
	List<StoreItem> findAllBySubcategoryAndRegion(Long subcategoryId, Long regionId);
}

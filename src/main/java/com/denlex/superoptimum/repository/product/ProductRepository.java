package com.denlex.superoptimum.repository.product;

import com.denlex.superoptimum.domain.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Shishkov A.V. on 07.08.18.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	@Query(
			nativeQuery = true,
			value = "select p.* " +
					"from super_optimum.product p " +
					"join super_optimum.subcategory sub_cat on p.subcategory_id = sub_cat.id " +
					"join super_optimum.category cat on sub_cat.category_id = cat.id " +
					"where cat.id = ?1"
	)
	List<Product> findAllByCategory(Long categoryId);

	@Query(
			nativeQuery = true,
			value = "select p.* " +
					"from super_optimum.product p " +
					"join super_optimum.subcategory sub_cat on p.subcategory_id = sub_cat.id " +
					"where sub_cat.id = ?1"
	)
	List<Product> findAllBySubCategory(Long subcategoryId);
}

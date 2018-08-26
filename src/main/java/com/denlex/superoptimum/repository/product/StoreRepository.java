package com.denlex.superoptimum.repository.product;

import com.denlex.superoptimum.domain.product.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Shishkov A.V. on 25.08.18.
 */
@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {
	@Query(
			nativeQuery = true,
			value = "select st.* " +
					"from store st " +
					"join city c on st.city_id = c.id " +
					"where c.id = ?1"
	)
	List<Store> findStoresByCity(Long cityId);

	@Query(
			nativeQuery = true,
			value = "select st.* " +
					"from store st " +
					"join city c on st.city_id = c.id " +
					"join region r on c.region_id = r.id " +
					"where r.id = ?1"
	)
	List<Store> findStoresByRegion(Long regionId);
}

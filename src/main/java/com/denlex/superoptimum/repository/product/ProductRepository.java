package com.denlex.superoptimum.repository.product;

import com.denlex.superoptimum.domain.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Shishkov A.V. on 07.08.18.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}

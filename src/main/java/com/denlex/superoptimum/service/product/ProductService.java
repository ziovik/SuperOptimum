package com.denlex.superoptimum.service.product;

import com.denlex.superoptimum.domain.product.Product;

import java.util.List;

/**
 * Created by Shishkov A.V. on 07.08.18.
 */
public interface ProductService {
	List<Product> findAll();
	Product save(Product product);
}

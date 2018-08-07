package com.denlex.superoptimum.service.product.impl;

import com.denlex.superoptimum.domain.product.Product;
import com.denlex.superoptimum.repository.product.ProductRepository;
import com.denlex.superoptimum.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Shishkov A.V. on 07.08.18.
 */
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product save(Product product) {
		return productRepository.save(product);
	}
}

package com.denlex.superoptimum.service.product.impl;

import com.denlex.superoptimum.domain.product.Product;
import com.denlex.superoptimum.repository.product.ProductRepository;
import com.denlex.superoptimum.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Shishkov A.V. on 07.08.18.
 */
@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> findAll() {
		return productRepository.findAll();
	}

	/*@Override
	public List<Product> findAllByCategoryAndRegion(@NotNull Long categoryId, @NotNull Long regionId) {
		return productRepository.findAllByCategoryAndRegion(categoryId, regionId);
	}

	@Override
	public List<Product> findAllBySubCategoryAndRegion(@NotNull Long subCategoryId, @NotNull Long regionId) {
		return productRepository.findAllBySubCategoryAndRegion(subCategoryId, regionId);
	}*/

	@Override
	public Product save(Product product) {
		return productRepository.save(product);
	}

	@Override
	public List<Product> findAllByCategory(Long categoryId) {
		return productRepository.findAllByCategory(categoryId);
	}

	@Override
	public List<Product> findAllBySubCategory(Long subcategoryId) {
		return productRepository.findAllBySubCategory(subcategoryId);
	}
}

package com.denlex.superoptimum.service.product.impl;

import com.denlex.superoptimum.service.product.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Shishkov A.V. on 22.08.18.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {
	@Autowired
	private ProductService productService;

	@Test
	public void findAllByCategory() {
		productService.findAllByCategory(12L);
	}

	@Test
	public void findAllBySubCategory() {
		productService.findAllBySubCategory(12L);
	}
}
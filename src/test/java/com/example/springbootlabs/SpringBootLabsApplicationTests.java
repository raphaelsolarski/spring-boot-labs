package com.example.springbootlabs;

import com.example.springbootlabs.product.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
class SpringBootLabsApplicationTests {

	@Autowired
	private ProductRepository productRepository;

	@Test
	void contextLoads() {
		productRepository.getProducts();
	}

}

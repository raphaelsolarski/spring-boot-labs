package com.example.springbootlabs;

import com.example.springbootlabs.product.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
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

	@TestConfiguration
	public static class ConfigurationForTests {
		@Bean
		public ProductRepository secondaryRepository() {
			return new ProductRepository() {};
		}
	}

}

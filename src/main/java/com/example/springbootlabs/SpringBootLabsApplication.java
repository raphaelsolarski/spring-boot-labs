package com.example.springbootlabs;

import com.example.springbootlabs.product.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class SpringBootLabsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootLabsApplication.class, args);
	}

	@GetMapping
	public List<Product> hello(){
		return List.of(
				new Product(1L,"Biurko Narozne","Biurko z szufladą na klawiaturę",550.0),
				new Product(1L,"Krzesło","Krzesło bez podłokietników",120.0)
		);
	}

}

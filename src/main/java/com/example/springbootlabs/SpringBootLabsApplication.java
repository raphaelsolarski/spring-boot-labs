package com.example.springbootlabs;

import com.example.springbootlabs.product.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

@SpringBootApplication
@EnableWebMvc
public class SpringBootLabsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootLabsApplication.class, args);
	}



}

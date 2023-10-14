package com.example.springbootlabs;

import com.example.springbootlabs.student.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootLabsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootLabsApplication.class, args);
	}

}

package com.example.springbootlabs;

import com.example.springbootlabs.student.Student;
import com.example.springbootlabs.teacher.Teacher;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SpringBootLabsApplication {
//	private static Logger logger = LogManager.getLogger(SpringBootLabsApplication.class);
//	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit");
	public static void main(String[] args) {
		SpringApplication.run(SpringBootLabsApplication.class, args);
/*		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();

		List<Teacher> teachers = em.createQuery("select t from Teacher t").getResultList();
		for (Teacher teacher : teachers) {
			logger.info(teacher.getSubjects());
		}
		em.getTransaction().commit();
		em.close();*/
	}

}

package com.example.springbootlabs.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByFirstNameAndLastName(String firstName, String lastName);
    List<Student> findByFirstNameStartingWith(String prefix);
    @Query("SELECT s FROM Student s WHERE s.firstName = :name")
    List<Student> findStudentsByFirstNameJPQL(@Param("name") String name);

    @Query("SELECT s FROM Student s JOIN s.subjects subj WHERE subj.name = :subjectName")
    List<Student> findStudentsBySubjectNameJPQL(@Param("subjectName") String subjectName);

    @Query(value = "SELECT * FROM Student WHERE first_name = :name", nativeQuery = true)
    List<Student> findStudentsByFirstNameNative(@Param("name") String name);

    @Query(value = "SELECT * FROM Student WHERE last_name = :lastName", nativeQuery = true)
    List<Student> findStudentsByLastNameNative(@Param("lastName") String lastName);

}






























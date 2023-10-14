package com.example.springbootlabs.student;

import com.example.springbootlabs.subject.Subject;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@ToString
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String uuid = UUID.randomUUID().toString();
    private String firstName;
    private String lastName;
    private LocalDateTime timeOfCreation;

    public Student(String firstName, String lastName, LocalDateTime timeOfCreation) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.timeOfCreation = timeOfCreation;
    }
}
































/*
@ToString(exclude = "subjects")
    @JsonIgnore
    @ManyToMany(mappedBy = "enrolledStudents")
    private Set<Subject> subjects = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(uuid, student.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }*/

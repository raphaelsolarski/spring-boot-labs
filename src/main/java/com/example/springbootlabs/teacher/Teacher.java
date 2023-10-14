package com.example.springbootlabs.teacher;

import com.example.springbootlabs.subject.Subject;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@ToString
@NoArgsConstructor
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;
    String uuid = UUID.randomUUID().toString();

    public Teacher(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }
}





































/*
    @ToString(exclude = "subjects")

    @JsonIgnore
    @OneToMany(mappedBy = "teacher")
    private Set<Subject> subjects;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(uuid, teacher.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }*/

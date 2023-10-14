package com.example.springbootlabs.teacher;

import com.example.springbootlabs.subject.Subject;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.NaturalId;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@ToString(exclude = "subjects")
@NoArgsConstructor
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;
    String uuid = UUID.randomUUID().toString();
    @NaturalId
    private String teacherId;
    public Teacher(String firstname, String lastname, String teacherId) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.teacherId=teacherId;
    }

    //@JsonIgnore
    @OneToMany(mappedBy = "teacher")
    private Set<Subject> subjects;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(teacherId, teacher.teacherId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teacherId);
    }
}
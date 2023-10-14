package com.example.springbootlabs.config;

import com.example.springbootlabs.student.Student;
import com.example.springbootlabs.student.StudentRepository;
import com.example.springbootlabs.subject.Subject;
import com.example.springbootlabs.subject.SubjectRepository;
import com.example.springbootlabs.teacher.Teacher;
import com.example.springbootlabs.teacher.TeacherRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;


@AllArgsConstructor
@Configuration
public class Config implements CommandLineRunner {
    private StudentRepository studentRepository;
    private SubjectRepository subjectRepository;
    private TeacherRepository teacherRepository;

    @Override
    public void run(String... args) throws Exception {
        Teacher teacher = new Teacher("t_fn1", "t_ln2");
        teacherRepository.save(teacher);
        Subject subject = new Subject("Mathematics");
        subjectRepository.save(subject);
        subject.setTeacher(teacher);
        Student student = new Student("John","Doe",LocalDateTime.now());
        studentRepository.save(student);
        student.getSubjects().add(subject);
        subject.getEnrolledStudents().add(student);
    }
}

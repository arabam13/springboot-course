package com.course.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.course.api.models.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findALLByFirstName(String firstname);
}

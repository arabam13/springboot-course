package com.course.api.mappers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.api.models.School;
import com.course.api.models.Student;
import com.course.api.records.StudentDTO;
import com.course.api.records.StudentResponseDTO;
import com.course.api.repositories.SchoolRepository;
import com.course.api.repositories.StudentRepository;

@Service
public class StudentMapper {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private SchoolRepository schoolRepository;

    public Optional<Student> toStudent(StudentDTO dto) {
        Student student = new Student();
        student.setFirstName(dto.firstName());
        student.setLastName(dto.lastName());
        student.setEmail(dto.email());

        Optional<School> existingSchool = schoolRepository.findById(dto.schoolId());
        if (existingSchool.isPresent()) {
            student.setSchool(existingSchool.get());
            studentRepository.save(student);
            return Optional.of(student);
        } else {
            return Optional.empty();
        }
        
    }

    public StudentResponseDTO toStudentResponseDTO(Optional<Student>  studentParam) {
        Student student = studentParam.get();
        return new StudentResponseDTO(student.getFirstName(), student.getLastName(), student.getEmail());
    }
}
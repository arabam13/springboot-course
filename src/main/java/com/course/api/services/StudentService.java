package com.course.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.course.api.mappers.StudentMapper;
import com.course.api.models.Student;
import com.course.api.records.StudentDTO;
import com.course.api.records.StudentResponseDTO;
import com.course.api.repositories.SchoolRepository;
import com.course.api.repositories.StudentRepository;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    
    public StudentService(StudentRepository studentRepository, SchoolRepository schoolRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    public List<StudentDTO> findAllStudents() {
        var students = studentRepository.findAll();
        return students.stream()
            .map(student -> new StudentDTO(student.getFirstName(), student.getLastName(), student.getEmail(), student.getSchool().getId()))
            .toList();
    }

    public StudentResponseDTO  createStudent(StudentDTO dto) {
        Optional<Student> student = studentMapper.toStudent(dto);

        // if (student.isPresent()) {
        StudentResponseDTO responseDTO = studentMapper.toStudentResponseDTO(student);
        return responseDTO;
        // } 
        // else {
        //     return ResponseEntity.notFound().build();
        // }
    }

    public StudentResponseDTO findStudentById(Integer id) {
        Student student = studentRepository.findById(id).orElse(null);
        return new StudentResponseDTO(student.getFirstName(), student.getLastName(), student.getEmail());
    }

    public List<StudentResponseDTO> findStudentByFirstname(String firstname) {
        List<Student> students = studentRepository.findALLByFirstName(firstname);
        return students.stream()
            .map(student -> new StudentResponseDTO(student.getFirstName(), student.getLastName(), student.getEmail()))
            .toList();
    }

    public void deleteStudent(Integer id) {
        studentRepository.deleteById(id);
    }

    public ResponseEntity<?> updateStudentFirstName(Integer studentId, Student studentBody) {
        if (studentBody.getFirstName().length() > 20) {
            return ResponseEntity.badRequest().body("First name length exceeds the maximum allowed length of 20 characters.");
        }
        Optional<Student> studentOptional = studentRepository.findById(studentId);
        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            if (student.getFirstName().contentEquals(studentBody.getFirstName())) {
                return ResponseEntity.badRequest().body("First name of Body is the same as the current first name in DB.");
            }
            student.setFirstName(studentBody.getFirstName());
            Student updatedStudent = studentRepository.save(student);
            return ResponseEntity.ok(updatedStudent);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

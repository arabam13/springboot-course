package com.course.api.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.course.api.models.School;
import com.course.api.models.Student;
import com.course.api.records.StudentDTO;
import com.course.api.records.StudentResponseDTO;
import com.course.api.repositories.SchoolRepository;
import com.course.api.repositories.StudentRepository;


@RestController
// @RequestMapping("/api/v1")
public class StudentController {

    private final StudentRepository studentRepository;
    private final SchoolRepository schoolRepository;
    public StudentController(StudentRepository studentRepository, SchoolRepository schoolRepository) {
        this.studentRepository = studentRepository;
        this.schoolRepository = schoolRepository;
    }

    
    @PostMapping("/students")
    public ResponseEntity<StudentResponseDTO>  create(@RequestBody StudentDTO dto) {
        Optional<Student> student = toStudent(dto);
        return toStudentResponseDTO(student);
    }

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

    public ResponseEntity<StudentResponseDTO> toStudentResponseDTO(Optional<Student>  optionalStudent) {
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            return ResponseEntity.ok(new StudentResponseDTO(student.getFirstName(), student.getLastName(), student.getEmail()));
        }else{
            return ResponseEntity.notFound().build();
        }

    }

    @GetMapping("/students")
    public List<StudentDTO> findAll() {
        var students = studentRepository.findAll();
        return students.stream()
            .map(student -> new StudentDTO(student.getFirstName(), student.getLastName(), student.getEmail(), student.getSchool().getId()))
            .toList();
    }

    @GetMapping("/students/{student-id}")
    public Optional<Student> findStudentById(@PathVariable("student-id") Integer id) {
        return studentRepository.findById(id);
    }

    @GetMapping("/students/search/{student-firstname}")
    public List<Student> findStudentByFirstname(@PathVariable("student-firstname") String firstname) {
        return studentRepository.findALLByFirstName(firstname);
    }

    @DeleteMapping("/students/{student-id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteStudent(@PathVariable("student-id") Integer id) {
        studentRepository.deleteById(id);
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<?> updateStudentFirstName(@PathVariable Integer id, @RequestBody Student studentBody) {
        if (studentBody.getFirstName().length() > 20) {
            return ResponseEntity.badRequest().body("First name length exceeds the maximum allowed length of 20 characters.");
        }
        Optional<Student> studentOptional = studentRepository.findById(id);
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
            // return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}


package com.course.api.controllers;

import java.util.List;

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

import com.course.api.models.Student;
import com.course.api.records.StudentDTO;
import com.course.api.records.StudentResponseDTO;
import com.course.api.services.StudentService;


@RestController
// @RequestMapping("/api/v1")
public class StudentController {

    private final StudentService studentService;
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    
    @PostMapping("/students")
    public ResponseEntity<StudentResponseDTO> create(@RequestBody StudentDTO dto) {
        return studentService.createStudent(dto);
    }

    @GetMapping("/students")
    public List<StudentDTO> findAll() {
        return studentService.findAllStudents();
    }

    @GetMapping("/students/{student-id}")
    public StudentResponseDTO findStudentById(@PathVariable("student-id") Integer id) {
        return studentService.findStudentById(id);
    }

    @GetMapping("/students/search/{student-firstname}")
    public List<StudentResponseDTO> findStudentByFirstname(@PathVariable("student-firstname") String firstname) {
        return studentService.findStudentByFirstname(firstname);
    }

    @DeleteMapping("/students/{student-id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteStudent(@PathVariable("student-id") Integer id) {
        studentService.deleteStudent(id);
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<?> updateStudentFirstName(@PathVariable("id") Integer studentId, @RequestBody Student studentBody) {

        return studentService.updateStudentFirstName(studentId, studentBody);
    }
}


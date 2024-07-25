package com.course.api.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.course.api.mappers.SchoolMapper;
import com.course.api.models.School;
import com.course.api.records.SchoolDTO;
import com.course.api.repositories.SchoolRepository;

@RestController
public class SchoolController{

    private final SchoolRepository schoolRepository;
    public SchoolController(SchoolRepository schoolRepository){
        this.schoolRepository = schoolRepository;
    }

    @PostMapping("/schools")
    public ResponseEntity<School> create(@RequestBody School body) {
         School savedSchool = schoolRepository.save(body);
        return ResponseEntity.ok(savedSchool);
    }

    @GetMapping("/schools")
    public List<SchoolDTO> findAll() {
        List<School> schools = schoolRepository.findAll();
        return schools.stream().map(SchoolMapper::toDTO)
        .collect(Collectors.toList());
    }

}
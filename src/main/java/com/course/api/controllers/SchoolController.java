package com.course.api.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.course.api.models.School;
import com.course.api.records.SchoolDTO;
import com.course.api.services.SchoolService;

@RestController
public class SchoolController{

    private final SchoolService schoolService;
    public SchoolController(SchoolService schoolService){
        this.schoolService = schoolService;
    }

    @PostMapping("/schools")
    public ResponseEntity<SchoolDTO> create(@RequestBody School body) {
        return schoolService.createSchool(body);
    }

    @GetMapping("/schools")
    public List<String> findAll() {
        return schoolService.findAllSchools();
    }

}
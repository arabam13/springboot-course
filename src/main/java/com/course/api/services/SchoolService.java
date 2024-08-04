package com.course.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.course.api.mappers.SchoolMapper;
import com.course.api.models.School;
import com.course.api.records.SchoolDTO;
import com.course.api.repositories.SchoolRepository;

@Service
public class SchoolService {
    @Autowired
    private SchoolRepository schoolRepository;

    public ResponseEntity<SchoolDTO> createSchool(School body) {
        School savedSchool = schoolRepository.save(body);
        return ResponseEntity.ok(new SchoolDTO(savedSchool.getName()));
    }

    public List<String> findAllSchools() {
        List<School> schools = schoolRepository.findAll();
        return schools
        .stream()
        .map(SchoolMapper::toDTO)
        .map(schoolDTO -> schoolDTO.name())
        .toList();
    }

}

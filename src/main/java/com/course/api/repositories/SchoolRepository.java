package com.course.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.course.api.models.School;

public interface SchoolRepository extends JpaRepository<School, Integer> {
    
}

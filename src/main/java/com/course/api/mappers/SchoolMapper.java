package com.course.api.mappers;

import com.course.api.models.School;
import com.course.api.records.SchoolDTO;

public class SchoolMapper {
    public static SchoolDTO toDTO(School school) {
        SchoolDTO dto = new SchoolDTO(school.getName());
        return dto;
    }
}

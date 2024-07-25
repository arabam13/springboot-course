package com.course.api.records;

public record StudentDTO(
    String firstName,
    String lastName,
    String email,
    Integer schoolId
) {

}

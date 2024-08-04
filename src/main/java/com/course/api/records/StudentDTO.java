package com.course.api.records;

import jakarta.validation.constraints.NotEmpty;

public record StudentDTO(
    @NotEmpty(message = "First name must not be empty")
    String firstName,
    String lastName,
    String email,
    Integer schoolId
) {

}

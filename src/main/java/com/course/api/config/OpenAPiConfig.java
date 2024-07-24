package com.course.api.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
    info =@Info(
        contact = @Contact(
            name="Mohamed ARABA",
            email="araba.mohamed@gmail.com",
            url="https://mohammed-araba.fr"
        ),
        description="This is a simple API for a course management system",
        title="Course Management API",
        version="1.0.0"
    ),
    servers={
        @Server(
            url="http://localhost:8080",
            description="Local server"
        ),
        @Server(
            url="http://real-website.cms/students",
            description="Prod server"
        ),
    },
    security={
        @SecurityRequirement(name="bearerAuth")
    }
)
@SecurityScheme(
    name="bearerAuth",
    description = "Bearer Token",
    scheme="bearer",
    type=SecuritySchemeType.HTTP,
    bearerFormat="JWT",
    in=SecuritySchemeIn.HEADER
)
public class OpenAPiConfig {
    
}

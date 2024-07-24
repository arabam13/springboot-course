package com.course.api;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CourseApplication {

	public static void main(String[] args) {
		// var ctx = SpringApplication.run(CourseApplication.class, args);
		var app = new SpringApplication(CourseApplication.class);
		app.setDefaultProperties(Collections.singletonMap("spring.profiles.active", "dev"));
		var ctx = app.run(args);

		// HellowWorld helloWorld = new HellowWorld();
		// HellowWorld helloWorld = ctx.getBean("hellowWorld", HellowWorld.class);
		FirstService firstService = ctx.getBean(FirstService.class);
		System.out.println(firstService.tellStory());
		System.out.println(firstService.getPropertyValue());
	}

}

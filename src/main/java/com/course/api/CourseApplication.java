package com.course.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CourseApplication {

	public static void main(String[] args) {
		var ctx = SpringApplication.run(CourseApplication.class, args);

		// HellowWorld helloWorld = new HellowWorld();
		// HellowWorld helloWorld = ctx.getBean("hellowWorld", HellowWorld.class);
		FirstService firstService = ctx.getBean(FirstService.class);
		System.out.println(firstService.tellStory());
	}

}

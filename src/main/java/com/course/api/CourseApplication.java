package com.course.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CourseApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseApplication.class, args);

		// // test de la méthode Collections.singletonMap()
		// // Création d'une carte immuable avec une seule entrée
		// Map<String, String> singleEntryMap = Collections.singletonMap("courseName", "Java Programming");
        // // Création d'une nouvelle carte mutable basée sur la carte immuable
        // Map<String, String> mutableMap = new HashMap<>(singleEntryMap);
        // // Modification de la nouvelle carte mutable
        // mutableMap.put("courseLevel", "Intermediate");
        // // Affichage de la carte modifiée
        // System.out.println("Mutable Map: " + mutableMap);


		// var ctx = SpringApplication.run(CourseApplication.class, args);
		// var app = new SpringApplication(CourseApplication.class);
		// app.setDefaultProperties(Collections.singletonMap("spring.profiles.active", "dev"));
		// var ctx = app.run(args);

		// HellowWorld helloWorld = new HellowWorld();
		// HellowWorld helloWorld = ctx.getBean("hellowWorld", HellowWorld.class);
		// FirstService firstService = ctx.getBean(FirstService.class);
		// System.out.println(firstService.tellStory());
		// System.out.println(firstService.getPropertyValue());
	}

}

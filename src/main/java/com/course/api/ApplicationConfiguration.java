package com.course.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

	@Bean
	public HellowWorld hellowWorld() {
		return new HellowWorld("My first bean");
	}

	@Bean
	// @Primary
	public HellowWorld mySecondBean() {
		return new HellowWorld("My second bean");
	}
}

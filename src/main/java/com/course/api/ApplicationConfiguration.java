package com.course.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class ApplicationConfiguration {

	@Bean
	public HellowWorld hellowWorld() {
		return new HellowWorld("My principale bean");
	}

	@Bean(name = "bean1")
	// @Profile("dev")
	public HellowWorld myFirstBean() {
		return new HellowWorld("My first bean");
	}

	@Bean
	// @Profile("test")
	// @Primary
	public HellowWorld mySecondBean() {
		return new HellowWorld("My second bean");
	}
}

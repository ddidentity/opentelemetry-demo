package com.example.otel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class HelloWorldApplication
{

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(com.example.otel.HelloWorldApplication.class);
		springApplication.addListeners(new ApplicationPidFileWriter("./application.pid"));
		springApplication.run( args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

}

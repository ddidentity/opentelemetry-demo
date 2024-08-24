package com.example.otel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;

@SpringBootApplication
public class HiThereApplication
{

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(HiThereApplication.class);
		springApplication.addListeners(new ApplicationPidFileWriter("./application.pid"));
		springApplication.run( args);
	}

}

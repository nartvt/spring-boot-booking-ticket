package com.program;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200")
@SpringBootApplication
@ComponentScan({"com.program.entity",
  "com.program.repository",
  "com.program.service",
  "com.program.controller",
  "com.program.security",
  "com.program.authentication"})
public class SpringBootBookingTicketApplication {
  
	public static void main(String[] args) {
		SpringApplication.run(SpringBootBookingTicketApplication.class, args);
	}

}

package com.program;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.program.filetransfer.FileStorageProperties;

@SpringBootApplication
@CrossOrigin(origins = "http://localhost:4200")
@EnableConfigurationProperties({FileStorageProperties.class})
public class SpringBootBookingTicketApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBookingTicketApplication.class, args);
	}

}

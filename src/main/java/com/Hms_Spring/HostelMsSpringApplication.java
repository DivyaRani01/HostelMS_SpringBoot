package com.Hms_Spring;
//importing required classes and packages
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

//using class level annotation
@EnableSwagger2
@SpringBootApplication
public class HostelMsSpringApplication {

	//main method
	public static void main(String[] args) {
		SpringApplication.run(HostelMsSpringApplication.class, args);
	}

}

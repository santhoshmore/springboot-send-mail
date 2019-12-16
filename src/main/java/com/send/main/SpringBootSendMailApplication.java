package com.send.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.send.*")
@Configuration
@SpringBootApplication
public class SpringBootSendMailApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootSendMailApplication.class, args);
	}

}

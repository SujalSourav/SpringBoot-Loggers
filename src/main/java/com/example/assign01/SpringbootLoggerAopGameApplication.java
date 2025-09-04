package com.example.assign01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootLoggerAopGameApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(SpringbootLoggerAopGameApplication.class);
	
	public static void main(String[] args) {
        SpringApplication.run(SpringbootLoggerAopGameApplication.class, args);
    }


}

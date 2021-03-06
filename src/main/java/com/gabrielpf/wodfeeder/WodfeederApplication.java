package com.gabrielpf.wodfeeder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class WodfeederApplication {

	public static void main(String[] args) {
		SpringApplication.run(WodfeederApplication.class, args);
	}

}


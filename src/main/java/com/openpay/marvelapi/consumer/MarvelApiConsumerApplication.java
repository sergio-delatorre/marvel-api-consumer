package com.openpay.marvelapi.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.openpay.marvelapi.client","com.openpay.marvelapi.consumer"})
public class MarvelApiConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarvelApiConsumerApplication.class, args);
	}

}

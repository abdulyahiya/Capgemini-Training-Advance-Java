package com.spring.REST;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BookStoreInventoryManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookStoreInventoryManagementApplication.class, args);
	}

}

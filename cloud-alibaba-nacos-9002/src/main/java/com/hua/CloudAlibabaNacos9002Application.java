package com.hua;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Hello world!
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CloudAlibabaNacos9002Application {
	public static void main(String[] args) {
		SpringApplication.run(CloudAlibabaNacos9002Application.class);
	}
}

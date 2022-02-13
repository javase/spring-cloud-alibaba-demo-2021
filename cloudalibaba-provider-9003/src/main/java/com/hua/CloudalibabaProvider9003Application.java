package com.hua;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Hello world!
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CloudalibabaProvider9003Application {
	public static void main(String[] args) {
		SpringApplication.run(CloudalibabaProvider9003Application.class, args);
	}
}

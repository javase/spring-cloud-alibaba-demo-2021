package com.hua;

import feign.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

/**
 * Hello world!
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class CloudAlibabaOpenFeignConsumer8888Application {
	public static void main(String[] args) {
		SpringApplication.run(CloudAlibabaOpenFeignConsumer8888Application.class, args);
	}

	@Bean
	public Logger.Level feignLoggerLevel(){
		// 开启openFeign的详细日志
		return Logger.Level.FULL;
	}
}

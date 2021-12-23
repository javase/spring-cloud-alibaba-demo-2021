package com.hua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * created at 2021-12-23 20:56
 * @author lerry
 */
@RestController
public class DemoController {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${service-url.nacos-user-service}")
	private String serverURL;

	@GetMapping("/consumer/nacos")
	public String getDiscovery() {
		String forObject = restTemplate.getForObject(serverURL + "/mashibing", String.class);
		return forObject;

	}
}

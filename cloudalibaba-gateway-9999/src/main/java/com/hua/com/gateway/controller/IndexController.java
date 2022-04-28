package com.hua.com.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * created at 2022-04-28 19:43
 * @author lerry
 */
@RestController
public class IndexController {

	@GetMapping("/")
	public String home(){
		return "Hello，this is cloudalibaba-gateway-9999";
	}
}

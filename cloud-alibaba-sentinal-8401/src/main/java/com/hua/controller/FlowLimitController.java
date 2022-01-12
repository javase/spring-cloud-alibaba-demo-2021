package com.hua.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * created at 2022-01-13 07:33
 * @author lerry
 */
@RestController
public class FlowLimitController {

	@GetMapping("testA")
	public String testA() {
		return "----testA";
	}

	@GetMapping("testB")
	public String testB() {
		return "----testB";
	}
}

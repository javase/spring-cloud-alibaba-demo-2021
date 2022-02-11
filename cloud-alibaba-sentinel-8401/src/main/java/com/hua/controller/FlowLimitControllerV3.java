package com.hua.controller;

import com.hua.service.TestService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 演示排队等待（匀速器）的流控规则
 * created at 2022-01-13 07:33
 * @author lerry
 */
@Slf4j
@RestController
public class FlowLimitControllerV3 {

	@Autowired
	private TestService testService;

	@GetMapping("testA")
	public String testA() {
		log.info("{}:testA", Thread.currentThread().getName());
		return testService.common();
	}

	@GetMapping("testB")
	public String testB() {
		return testService.common();
	}
}

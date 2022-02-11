package com.hua.controller;

import java.util.concurrent.TimeUnit;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 演示慢调用比例的熔断规则
 * created at 2022-01-13 07:33
 * @author lerry
 */
@Slf4j
@RestController
public class FlowLimitControllerV4 {


	@GetMapping("testC")
	public String testA() {
		try {
			TimeUnit.SECONDS.sleep(5);
		}
		catch (InterruptedException e) {
			log.error("InterruptedException", e);
		}
		log.info("{}:testC", Thread.currentThread().getName());
		return "--------testC";
	}

}

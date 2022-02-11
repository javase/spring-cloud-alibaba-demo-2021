package com.hua.controller;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 演示异常数的熔断规则
 * created at 2022-02-11 14:25:49
 * @author lerry
 */
@Slf4j
@RestController
public class FlowLimitControllerV6 {

	@GetMapping("testE")
	public String testE(Integer id) {
		if (id != null && id > 1) {
			throw new RuntimeException("异常数测试");
		}
		log.info("{}:testE id={}", Thread.currentThread().getName(), id);
		return String.format("--------testE id:%s",id);
	}

}

package com.hua.controller;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 演示异常比例的熔断规则
 * created at 2022-01-13 07:33
 * @author lerry
 */
@Slf4j
@RestController
public class FlowLimitControllerV5 {

	@GetMapping("testD")
	public String testD(Integer id) {
		if (id != null && id > 1) {
			throw new RuntimeException("异常比例测试");
		}
		log.info("{}:testD id={}", Thread.currentThread().getName(), id);
		return String.format("--------testD id:%s",id);
	}

}

package com.hua.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 演示Sentinel热点规则
 * created at 2022-02-11 14:25:49
 * @author lerry
 */
@Slf4j
@RestController
public class FlowLimitControllerV7 {

//	@GetMapping("/testHotKey")
//	@SentinelResource("testHotKey")
//	public String testHotKey(
//			@RequestParam(value = "hot1", required = false) String hot1,
//			@RequestParam(value = "hot2", required = false) String hot2,
//			@RequestParam(value = "hot3", required = false) String hot3
//	) {
//		return "-----testHotKey";
//	}

	@GetMapping("/testHotKey")
	@SentinelResource(value = "testHotKey",blockHandler = "handler_HotKey")
	public String testHotKey(
			@RequestParam(value = "hot1", required = false) String hot1,
			@RequestParam(value = "hot2", required = false) String hot2,
			@RequestParam(value = "hot3", required = false) String hot3
	) {
		return "-----testHotKey";
	}

	public String handler_HotKey(String hot1,String hot2,String hot3, BlockException blockException){
		return "系统繁忙，请稍候重试";
	}

}

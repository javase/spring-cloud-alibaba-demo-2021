package com.hua.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * created at 2022-02-13 10:19
 * @author lerry
 */
@RestController
public class SentinelResourceTestController {
	@GetMapping("/byResource")
	@SentinelResource(value = "byResource", blockHandler = "handler_resource")
	public String byResource() {
		return "-----byResource";
	}

	public String handler_resource(BlockException exception) {
		return "系统繁忙";
	}

	/**
	 * 我们还可以更换请求地址为资源
	 * @return
	 */
	@GetMapping("/byRest")
	@SentinelResource(value = "byRest")
	public String byRest() {
		return "-----byRest";
	}

}

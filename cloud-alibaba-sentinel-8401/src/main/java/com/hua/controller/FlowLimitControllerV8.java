package com.hua.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.hua.myhandler.CustomerBlockHandler;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 演示Sentinel自定义限流逻辑处理
 * created at 2022-02-11 14:25:49
 * @author lerry
 */
@Slf4j
@RestController
public class FlowLimitControllerV8 {

	/**
	 * 此方法用到了自定义限流处理类型CustomerBlockHandler
	 * 中的handlerException1方法来处理限流逻辑。
	 */
	@GetMapping("/byCustomer")
	@SentinelResource(value = "byCustomer",
			blockHandlerClass = CustomerBlockHandler.class,
			blockHandler = "handlerException1")
	public String byCustomer() {
		return "-----byCustomer";
	}

}

package com.hua.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * created at 2022-04-27 17:17
 * @author lerry
 */
@RestController
@RequestMapping("/msb")//路由路径
public class DemoForGateWayController {

	@Value("${server.port}")
	private String serverPort;

	@GetMapping(value = "/get")
	public String getServerPort() {
		return "库存-1：" + serverPort;
	}
}

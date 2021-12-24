package com.hua.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * created at 2021-12-24 19:19
 * @author lerry
 */
@RestController
@RefreshScope
public class ConfigClientController {

	@Value("${config.info}")
	private String configInfo;

	@GetMapping("/config/info")
	public String getConfigInfo() {
		return configInfo;
	}
}

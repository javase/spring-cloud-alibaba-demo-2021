package com.hua.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;

import org.springframework.stereotype.Service;

/**
 * created at 2022-01-20 22:00
 * @author lerry
 */
@Service
public class TestService {

	/**
	 * 定义限流规则
	 * @return
	 */
	@SentinelResource("common")
	public String common(){
		return "common";
	}
}

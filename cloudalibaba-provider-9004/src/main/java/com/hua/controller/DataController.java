package com.hua.controller;

import java.util.HashMap;

import com.hua.cloudalibabacommons.entity.JsonResult;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * created at 2022-02-13 11:15
 * @author lerry
 */
@RestController
public class DataController {

	@Value("${server.port}")
	private String serverPort;

	// 模仿数据库的数据存储
	public static HashMap<Long, String> hashMap = new HashMap<Long, String>();

	static {
		hashMap.put(1L, "鼠标");
		hashMap.put(2L, "键盘");
		hashMap.put(3L, "耳机");
	}

	@GetMapping("/info/{id}")
	public JsonResult<String> sql(@PathVariable("id") Long id) {
		JsonResult<String> result = new JsonResult<String>(200, serverPort + ":" + hashMap.get(id));
		return result;
	}
}

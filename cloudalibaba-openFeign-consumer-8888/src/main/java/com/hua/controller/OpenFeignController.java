package com.hua.controller;

import com.hua.cloudalibabacommons.entity.JsonResult;
import com.hua.service.OpenFeignService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * created at 2022-02-13 15:16
 * @author lerry
 */
@RestController
public class OpenFeignController {

	@Autowired
	private OpenFeignService openFeignService;

	@GetMapping("getInfo/{id}")
	public JsonResult<String> getInfo(@PathVariable("id") Long id) {
		return openFeignService.sql(id);
	}

	//OpenFeginController
	@GetMapping("/testTimeout")
	public String TestTimeout() {
		return openFeignService.timeOut();
	}
}

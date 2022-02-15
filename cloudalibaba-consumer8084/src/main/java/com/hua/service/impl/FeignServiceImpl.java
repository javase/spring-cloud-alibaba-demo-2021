package com.hua.service.impl;

import com.hua.cloudalibabacommons.entity.JsonResult;
import com.hua.service.FeignService;

import org.springframework.stereotype.Service;

/**
 * created at 2022-02-15 13:07
 * @author lerry
 */
@Service
public class FeignServiceImpl implements FeignService {
	@Override
	public JsonResult<String> sql(Long id) {
		return new JsonResult<>(444, "服务降级返回！");
	}
}

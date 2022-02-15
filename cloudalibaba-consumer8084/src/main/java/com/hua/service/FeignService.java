package com.hua.service;

import com.hua.cloudalibabacommons.entity.JsonResult;
import com.hua.service.impl.FeignServiceImpl;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * created at 2022-02-15 13:05
 * @author lerry
 */
@Service
@FeignClient(value = "nacos-provider", fallback = FeignServiceImpl.class)
public interface FeignService {

	@GetMapping("/info/{id}")
	JsonResult<String> sql(@PathVariable("id") Long id);
}

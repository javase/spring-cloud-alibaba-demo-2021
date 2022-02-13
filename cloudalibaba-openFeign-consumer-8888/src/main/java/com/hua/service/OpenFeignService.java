package com.hua.service;

import com.hua.cloudalibabacommons.entity.JsonResult;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * created at 2022-02-13 15:11
 * @author lerry
 */
@Service
@FeignClient("nacos-provider")
public interface OpenFeignService {

	@GetMapping("/info/{id}")
	JsonResult<String> sql(@PathVariable("id") Long id);
}

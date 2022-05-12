package com.hua.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * created at 2022-05-11 19:28
 * @author lerry
 */
@Service
@FeignClient("seata-stock-8802")
public interface FeignService {

	@GetMapping("/stock/decrement")
	String decrement(@RequestParam Long productId);
}

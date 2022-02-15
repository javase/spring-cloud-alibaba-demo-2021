package com.hua.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.hua.cloudalibabacommons.entity.JsonResult;
import com.hua.service.FeignService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * created at 2022-02-13 11:35
 * @author lerry
 */
@RestController
@Slf4j
public class DemoController {
	/**
	 * 服务提供者URL
	 */
	@Value("${service-url.nacos-user-service}")
	private String SERVICE_URL;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private FeignService feignService;

	@GetMapping("/getInfo/{id}")
	public JsonResult<String> getInfo(@PathVariable("id") Long id) {
		if (id > 3) {
			throw new RuntimeException("没有改ID");
		}
		else {
			return feignService.sql(id);
		}
	}

	//	@GetMapping("/consumer/fallback/{id}")
//	public JsonResult<String> fallback(@PathVariable Long id) {
//		//通过Ribbon发起远程访问，访问9003/9004
//		JsonResult<String> result = restTemplate.getForObject(SERVICE_URL + "/info/" + id, JsonResult.class);
//		return result;
//	}

	@GetMapping("/consumer/fallback/{id}")
	@SentinelResource(value = "fallback", fallback = "fallbackHandler", blockHandler = "blockHandler",
			exceptionsToIgnore = {NullPointerException.class})
	public JsonResult<String> fallback(@PathVariable Long id) {
		if (id <= 3) {
			//通过Ribbon发起远程访问，访问9003/9004
			JsonResult<String> result = restTemplate.getForObject(SERVICE_URL + "/info/" + id, JsonResult.class);
			log.info(result.getData());
			return result;
		}
		else {
			throw new NullPointerException("没有对应的数据记录");
		}
	}

	/**
	 * 处理Java异常
	 * @param id
	 * @param e
	 * @return
	 */
	public JsonResult<String> fallbackHandler(Long id, Throwable e) {
		JsonResult<String> result = new JsonResult<>(444, "出现未知商品ID");
		return result;
	}

	/**
	 * 处理sentinel限流
	 * @param id
	 * @param e
	 * @return
	 */
	public JsonResult<String> blockHandler(Long id, BlockException e) {
		JsonResult<String> result = new JsonResult<>(445, "BlockException限流");
		return result;
	}

}

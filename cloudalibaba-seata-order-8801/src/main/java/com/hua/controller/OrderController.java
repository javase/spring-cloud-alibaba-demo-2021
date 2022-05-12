package com.hua.controller;

import com.hua.service.OrderService;
import io.seata.spring.annotation.GlobalTransactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * created at 2022-05-11 16:26
 * @author lerry
 */
@RestController
public class OrderController {

	@Autowired
	private OrderService orderService;

	@GetMapping("/order/create")
	@GlobalTransactional // 开启分布式事务
	public String createOrder(@RequestParam Long productId) {
		orderService.buy(productId, 1);
		return "create order success";
	}
}

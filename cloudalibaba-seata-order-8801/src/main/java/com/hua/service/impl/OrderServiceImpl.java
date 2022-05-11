package com.hua.service.impl;


import com.hua.dao.entity.Order;
import com.hua.dao.repository.OrderRepository;
import com.hua.service.FeignService;
import com.hua.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * created at 2022-05-11 16:52
 * @author lerry
 */
@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private FeignService feignService;

	/**
	 * 创建订单
	 */
	@Override
	public void create(Long productId, Integer count) {
		Order order = new Order();
		order.setCount(count);
		order.setProductId(productId);
		orderRepository.save(order);
	}

	@Override
	public void buy(Long productId, Integer count) {
		// 扣减库存
		feignService.decrement(productId);

		// 模拟异常

		// 生成订单
		create(productId, count);
	}
}

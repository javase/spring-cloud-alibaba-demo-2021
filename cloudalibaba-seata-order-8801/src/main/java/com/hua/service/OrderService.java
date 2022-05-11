package com.hua.service;

/**
 * created at 2022-05-11 16:51
 * @author lerry
 */
public interface OrderService {
	/**
	 * 创建订单
	 */
	void create(Long productId, Integer count);

	void buy(Long productId, Integer count);
}

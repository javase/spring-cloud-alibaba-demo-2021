package com.hua.stock.service.impl;

import com.hua.stock.dao.repository.StockRepository;
import com.hua.stock.service.StockService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * created at 2022-05-11 17:07
 * @author lerry
 */
@Service
@Slf4j
public class StockServiceImpl implements StockService {

	@Autowired
	private StockRepository stockRepository;

	/**
	 * 库存-1
	 */
	@Override
	public void decrement(Long productId) {
//		Optional<Stock> byId = stockRepository.findById(productId);
//		if (byId.isPresent()) {
//			Stock stock = byId.get();
//			stock.setCount((stock.getCount() - 1));
//			Stock savedEntity = stockRepository.save(stock);
//			log.info("扣减后的库存为：{}", savedEntity.getCount());
//		}
//		else {
//			log.info("商品：{}不存在", productId);
//		}
		stockRepository.updateCount(productId);
	}
}

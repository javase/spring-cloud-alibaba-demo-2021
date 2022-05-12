package com.hua.stock.dao.repository;

import com.hua.stock.dao.entity.Stock;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * created at 2022-05-11 17:05
 * @author lerry
 */
public interface StockRepository extends JpaRepository<Stock, Long> {

	@Modifying
	@Transactional
	@Query(nativeQuery = true, value = "update tb_stock set count = count-1 where product_id = ?1")
	int updateCount(Long productId);
}

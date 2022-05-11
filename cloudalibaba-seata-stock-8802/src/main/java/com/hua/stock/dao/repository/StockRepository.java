package com.hua.stock.dao.repository;

import com.hua.stock.dao.entity.Stock;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * created at 2022-05-11 17:05
 * @author lerry
 */
public interface StockRepository extends JpaRepository<Stock, Long> {
}

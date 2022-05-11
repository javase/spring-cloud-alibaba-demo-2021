package com.hua.dao.repository;

import com.hua.dao.entity.Order;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * created at 2022-05-11 16:50
 * @author lerry
 */
public interface OrderRepository extends JpaRepository<Order,Long> {

}

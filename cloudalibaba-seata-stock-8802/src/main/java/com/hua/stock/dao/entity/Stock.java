package com.hua.stock.dao.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


/**
 * 库存表
 * created at 2022-05-11 17:01
 * @author lerry
 */
@Data
@Entity
@Table(name = "tb_stock")
public class Stock {

	/**
	 * 主键id
	 */
	@Id
	@Column(name = "product_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;

	/**
	 * 商品库存
	 */
	private Integer count;

	/**
	 * 价格
	 */
	private BigDecimal money;

}

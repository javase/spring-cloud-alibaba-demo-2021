package com.hua.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


/**
 * 订单表
 * created at 2022-05-11 16:46
 * @author lerry
 */
@Data
@Entity
@Table(name = "tb_order")
public class Order  {

	/**
	 * 主键id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private Long orderId;

	/**
	 * 商品id
	 */
	@Column(name = "product_id")
	private Long productId;

	/**
	 * 订单的商品数量
	 */
	private Integer count;

}

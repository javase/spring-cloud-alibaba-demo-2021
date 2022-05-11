package com.hua.stock.controller;

import com.hua.stock.service.StockService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * created at 2022-05-11 19:35
 * @author lerry
 */
@RestController
public class StockController {

	@Autowired
	private StockService stockService;

	@GetMapping("/stock/decrement")
	public String decrement(@RequestParam Long productId){
		stockService.decrement(productId);
		return "success";
	}
}

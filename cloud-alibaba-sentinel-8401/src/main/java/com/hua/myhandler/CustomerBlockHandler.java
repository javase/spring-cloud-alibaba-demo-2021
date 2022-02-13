package com.hua.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * created at 2022-02-13 10:04
 * @author lerry
 */
public class CustomerBlockHandler {
	public static String handlerException1(BlockException blockException) {
		return "handlerException1:系统异常，请稍后重试！";
	}

	public static String handlerException2(BlockException blockException) {
		return "handlerException2:网络崩溃，请稍后重试！";
	}
}

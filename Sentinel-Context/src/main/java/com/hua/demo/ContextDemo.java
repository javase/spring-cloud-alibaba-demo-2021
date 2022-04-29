package com.hua.demo;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.context.ContextUtil;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;

/**
 * Hello world!
 */
@Slf4j
public class ContextDemo {

	public void contextUtil() {
		//创建一个来自appA访问的Context
		//Context的名称为entrance1
		ContextUtil.enter("entrance1", "appA");
		// Entry就是一个资源操作对象
		Entry nodeA = null;
		try {
			//获取资源resource的entry
			nodeA = SphU.entry("resource1");//后续会展开这个位置
			// 如果代码走到这个位置，说明当前资源的请求通过了流控，可以继续进行相关业务处理
			log.info("resource1 passed");
		}
		catch (BlockException e) {
			// 如果没有通过走到了这里，就表示请求被限流，这里进行降级操作
			e.printStackTrace();
		}
		finally {
			if (nodeA != null) {
				nodeA.exit();
			}
		}
		//释放Context
		ContextUtil.exit();
	}

	public static void main(String[] args) {
		new ContextDemo().contextUtil();
	}
}

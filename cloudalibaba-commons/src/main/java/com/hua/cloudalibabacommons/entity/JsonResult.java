package com.hua.cloudalibabacommons.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * created at 2022-02-13 11:07
 * @author lerry
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsonResult<T> {
	private Integer code;

	private T data;
}

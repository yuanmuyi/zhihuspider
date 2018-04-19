package com.yy.dao.vo;

import lombok.Getter;

/**
 * @author: victor(yuanyang)
 * @date: 2018/4/19 23:26
 * @reviewer
 */
@Getter
public class ResponseResult {

	private Object data;

	private Integer code;

	private String msg;

	private Long ts = System.currentTimeMillis();

	public ResponseResult(Object data) {
		this.data = data;
	}

	public ResponseResult(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}

}

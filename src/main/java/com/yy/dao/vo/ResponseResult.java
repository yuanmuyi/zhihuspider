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

    private Boolean success;

    private Long ts = System.currentTimeMillis();

    public ResponseResult(Object data) {
        this.data = data;
        this.success = true;
        this.code = 200;
        this.msg = "success";
    }

    public ResponseResult(Object data, Integer code, String msg, Boolean success) {
        this.data = data;
        this.success = true;
        this.msg = msg;
        this.success = success;
    }

}

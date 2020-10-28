package com.xinyuan.ms.common.web;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author hzx
 * @Description:
 * @date 2018/4/918:27
 */
@Data
public class Message<T> {

    @ApiModelProperty(value = "返回信息", name = "message")
    private String message;

    @ApiModelProperty(value = "返回码", name = "code")
    private int code;

    @ApiModelProperty(value = "具体内容", name = "message")
    private T data;
}

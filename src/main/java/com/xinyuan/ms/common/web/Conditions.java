package com.xinyuan.ms.common.web;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author hzx
 * @Description:
 * @date 2018/4/918:27
 */
@Data
public class Conditions {

    @ApiModelProperty(value = "参数键(属性名)", name = "key" ,example = "id或schemeId")
    private String key;

    @ApiModelProperty(value = "参数值(属性值)", name = "value" ,example = "5")
    private Object value;

    @ApiModelProperty(value = "查询条件", name = "condition" ,example = "EQUAL")
    private String condition;
}

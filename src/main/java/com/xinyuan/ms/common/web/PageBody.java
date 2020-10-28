package com.xinyuan.ms.common.web;
import com.xinyuan.ms.common.service.Order;
import com.xinyuan.ms.common.service.PageBean;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;

/**
 * @author hzx
 * @Description:
 * @date 2018/4/917:48
 */
@Data
public class PageBody {

    @ApiModelProperty(value = "分页属性", name = "pageBean")
    private PageBean pageBean;

    @ApiModelProperty(value = "参数集合", name = "mapBeanList")
    private ArrayList<Conditions> conditions;

    @ApiModelProperty(value = "排序字段", name = "Order")
    private Order order;
}

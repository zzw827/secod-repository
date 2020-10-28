package com.xinyuan.ms.common.enums;

public enum OrderStatus {

    ORDER(1, "已下单"),

    PAY(2, "已付款"),

    SEND(3, "发货"),

    TAKE(4, "收货"),

    SEND_BACK(5, "寄回"),

    CHECKING(6, "检测中"),

    REPORT(7, "报告已发布"),

    COMPLETE(8, "已完成"),

    PASS(9, "已通过"),

    NOT_PASS(10, "未通过"),

    SEND_BOX(11, "发采样盒"),

    CANCEL(12, "已取消"),

    TO_ACCEPT(13, "待受理"),

    TAKE_BOX(14, "收采样盒");

    private Integer id;

    private String name;

    OrderStatus() {
    }


    public static OrderStatus getById(Integer id) {
        OrderStatus[] values = OrderStatus.values();
        for (OrderStatus orderStatus : values) {
            if (orderStatus.getId().equals(id)) {
                return orderStatus;
            }
        }
        return null;
    }

    OrderStatus(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }
}

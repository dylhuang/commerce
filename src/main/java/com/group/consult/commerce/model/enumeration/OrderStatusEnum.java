package com.group.consult.commerce.model.enumeration;

/**
 * 订单状态
 */
public enum OrderStatusEnum {

    init("init","待支付"),
    payed("payed","已支付"),
    closed("closed","已关闭"),
    part_refunded("part_refunded","部分退款"),
    refunded("refunded","全额退款"),
    finished("finished","已完成");

    private String code;
    private String message;
    OrderStatusEnum(String code, String message){
        this.code = code;
        this.message = message;
    }

    public String code() {
        return code;
    }

    public String message() {
        return message;
    }
}

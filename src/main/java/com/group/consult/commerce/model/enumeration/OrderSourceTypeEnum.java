package com.group.consult.commerce.model.enumeration;

/**
 * 订单来源类型
 */
public enum OrderSourceTypeEnum {

    normal("normal","常规"),
    meeting("meeting","会议");

    private String code;
    private String message;
    OrderSourceTypeEnum(String code, String message){
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

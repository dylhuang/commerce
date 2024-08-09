package com.group.consult.commerce.model.enumeration;

public enum MenuTypeEnum {

    M("M","目录"),
    C("C","菜单"),
    F("F","按钮");

    private String code;
    private String message;
    MenuTypeEnum(String code, String message){
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

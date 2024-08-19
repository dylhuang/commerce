package com.group.consult.commerce.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 接口响应码枚举
 *
 * @author lizisong
 * @since 2023/12/06
 */
@Getter
@AllArgsConstructor
public enum ApiCodeEnum {

    /**
     * 基础
     */
    SUCCESS(200, "操作成功"),

    FAIL(500, "操作失败"),

    /**
     * 通用
     */
    SYSTEM_ERROR(10001, "系统异常"),

    PARAM_SET_ILLEGAL(10002, "参数设置非法"),

    VALIDATE_ERROR(10003, "数据检验失败"),

    PARAMETER_PARSE_ERROR(10004, "请求参数解析异常"),

    NOT_FIND_ERROR(10005, "未查询到信息"),

    DB_EXE_FAIL(10006, "数据执行失败"),

    NO_DEL_SELF(10007, "不允许删除自己"),

    /**
     * 2____ 系统管理
     */
    PLACEHOLDER_2(20000, "占位"),

    IMAGE_QUERY_NOT_NULL(20001, "查询不到该图像"),

    NOTICE_QUERY_NOT_NULL(30001, "查询不到该公告"),

    /**
     * 3____ 商品管理
     */
    PLACEHOLDER_3(30000, "占位"),

    MERCHANDISE_QUERY_NOT_NULL(30001, "查询不到该商品"),

    /**
     * 4____ 订单管理
     */
    PLACEHOLDER_4(40000, "占位"),


    /**
     * 5____ 运营活动管理
     */
    PLACEHOLDER_5(50000, "占位"),


    /**
     * 6____ 会务管理
     */
    PLACEHOLDER_6(60000, "占位"),


    /**
     * 7____ 用户管理
     */
    PLACEHOLDER_7(70001, "占位"),
    USER_EXIST(70002, "用户已存在"),


    /**
     * 8____ 角色管理
     */
    PLACEHOLDER_8(80001, "占位"),
    ROLE_CODE_EXIST(80002, "角色编码已存在"),
    ROLE_ID_NOT(80003, "角色ID必填"),
    ROLE_MENU_BIND_ERROR(80004, "角色菜单绑定错误"),
    ROLE_SAVE_ERROR(80005, "角色保存错误"),
    ROLE_USING(80006, "角色使用中，不允许删除"),

    /**
     * 9____ 权限管理
     */
    PLACEHOLDER_9(90001, "占位"),
    CAPTCHA_EXPIRED(90002, "验证码错误或已过期"),
    USER_PWD_ERROR(90003, "用户名或密码错误"),
    USER_STATUS_ERROR(90004, "用户状态不正常"),
    NO_LOGIN_ERROR(90005, "未获取到登录信息"),
    HAS_CHILD_MENU(90006, "存在子菜单，不允许删除"),
    USING_MENU(90007, "菜单使用中，不允许删除"),
    OLD_PWD_ERROR(90008, "修改密码失败，旧密码错误"),

    /**
     * 10____ 评论管理
     */
    PLACEHOLDER_10(100000, "占位"),
    ;

    private final Integer code;

    private final String message;
}

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


    STANDARD_ERROR_CODE(600, "STANDARD_ERROR_CODE"),

    BUSINESS_ERROR_CODE(601, "BUSINESS_ERROR_CODE"),


    /**
     * 通用
     */
    SYSTEM_ERROR(10001, "系统异常"),

    PARAM_SET_ILLEGAL(10002, "参数设置非法"),

    VALIDATE_ERROR(10003, "数据检验失败"),

    PARAMETER_PARSE_ERROR(10004, "请求参数解析异常"),

    NOT_FIND_ERROR(10005, "未查询到信息"),

    NOW_IS_AFTER_END_TIME(10006, "当前已超过结束时间"),

    START_TIME_NOT_BEFORE_END_TIME(10007, "开始时间应早于结束时间"),

    GET_FIELD_VALUE_ERROR(10008, "解析EXCEL校验异常"),

    NOW_IS_AFTER_START_TIME(10009, "开始时间不能早于当前时间"),

    INCORRECT_USERNAME_OR_PASSWORD(10010, "用户名或密码错误"),

    NO_PERMISSION(10011, "无权限访问"),

    INVALID_TOKEN(10012, "认证已失效，请重新登录"),

    CONFIRM_PASSWORD_NOT_MATCH(10013, "确认密码不匹配"),

    USERNAME_EXIST(10014, "用户名已存在"),

    SYSTEM_BUSY(10015, "系统繁忙，请稍后再试"),

    ON_BLACKLIST(10016, "您已被加入黑名单"),

    WE_CHAT_API_ERROR(10017, "调用微信接口失败"),

    FILE_TYPE_NOT_SUPPORT(10018, "文件格式不支持"),

    SAME_STATUS(10019, "当前状态与要修改状态相同"),

    FILE_UPLOAD_ERROR(10020, "文件上传异常"),

    SYSTEM_CONVERSION_EXCEPTION(10021, "系统转换异常"),

    FILE_SIZE_OVER_LIMIT(10022, "文件大小超过限制"),

    ASSET_CATEGORY_NOT_SUPPORT(10023, "资产类别不支持"),

    ASSET_TYPE_NOT_SUPPORT(10024, "资产类型不支持"),

    FIELD_ERROR(100025, "错误信息"),

    /**
     * 2____ 平台报告
     */
    PLACEHOLDER_2(20000, "占位"),

    /**
     * 3____ 首页广告位管理
     */
    PLACEHOLDER_3(30000, "占位"),

    /**
     * 4____ 配方管理
     */
    PLACEHOLDER_4(40000, "占位"),

    APPLICATION_DOWNLOAD_TEMPLATE(40001, "下载配方模板时出现错误"),

    APPLICATION_NOT_EXIST(40002, "当前配方不存在"),

    APPLICATION_NOT_SUPPORT_LISTING(40003, "当前状态不支持发布"),

    APPLICATION_NOT_SUPPORT_DELISTED(40004, "当前状态不支持下架"),

    APPLICATION_LACK_MATERIAL(40005, "请确认配方的原料信息"),

    APPLICATION_LACK_MARKETING(40006, "请确认配方的市场信息"),

    APPLICATION_LACK_MATERIAL_PERCENT(40007, "请确认配方的原料信息百分比"),

    APPLICATION_LACK_MATERIAL_QUANTITY(40008, "请确认配方的原料信息数量"),

    APPLICATION_NOT_GO_BACK(40009, "当前配方不能被退回"),

    APPLICATION_NOT_GO_BACK_BY_ROLE(40010, "当前配方状态不被当前角色退回"),

    APPLICATION_LACK_TAG(40011, "请确认配方的标签信息"),

    APPLICATION_EXCEL_TOTAL_APPLICATION(40012, "请确认导入配方的总配方组成"),

    APPLICATION_EXCEL_TOTAL_APPLICATION_QUANTITY_SUM(40013, "导入配方的总配方组成小记数量不能为空"),

    APPLICATION_NOT_DELETE_PUBLISH_DELISTED(40014, "配方发布后或下架后不能被删除"),

    APPLICATION_NOT_DELETE_ROLE_STATUS(40015, "当前角色不能删除当前状态配方"),

    APPLICATION_EXCEL_NAME_NULL(40016, "品名 Item"),

    APPLICATION_EXCEL_WEIGHT_NULL(40017, "净重"),

    APPLICATION_EXCEL_VIP_NULL(40018, "是否VIP配方"),

    APPLICATION_EXCEL_DEVELOPER_NULL(40019, "配方创作研发人"),

    APPLICATION_EXCEL_SERIAL_NOT_EQUAL_MATERIAL(40020, "导入配方的总配方序号与原料详细不一致"),

    APPLICATION_EXCEL_TOTAL_SERIAL(40021, "总配方组成序号"),

    APPLICATION_EXCEL_TOTAL_MATERIAL(40022, "总配方组成原料"),

    APPLICATION_EXCEL_TOTAL_QUANTITY(40023, "总配方组成数量"),

    APPLICATION_EXCEL_TOTAL_PERCENT(40024, "总配方组成百分比"),

    APPLICATION_EXCEL_MATERIAL_SERIAL(40025, "原料组合序号"),

    APPLICATION_EXCEL_MATERIAL_MATERIAL(40026, "原料组合原料"),

    APPLICATION_EXCEL_MATERIAL_QUANTITY(40027, "原料组合数量"),

    APPLICATION_EXCEL_MATERIAL_PERCENT(40028, "原料组合百分比"),

    APPLICATION_EXCEL_MATERIAL_ANCHOR(40029, "导原料组合是否是安佳专业乳品原料"),

    APPLICATION_NOT_NULL(40030, "为必填项，不能为空"),

    APPLICATION_FORMAT_ERROR(40031, "格式输入有误"),

    APPLICATION_STRING_MORE_THAN_FIFTY(40032, "限制输入50字"),

    APPLICATION_STRING_MORE_THAN_FIVE_HUNDRED(40033, "限制输入500字"),

    APPLICATION_ROLE_NOT_HANDLE_ADMIN(40034, "当前角色无法操作Admin创建的配方"),

    APPLICATION_TYPE_NOT_MATCH(40035, "当前配方类型与VIP配方不一致"),

    /**
     * 5____ 产品管理
     */
    PRODUCT_NOT_CONTAINS_GROUP(50001, "无法找到安佳产品组"),

    PRODUCT_NOT_EXIST(50002, "当前产品不存在"),

    PRODUCT_NOT_SUPPORT_LISTING(50003, "当前状态不支持发布"),

    PRODUCT_NOT_SUPPORT_DELISTED(50004, "当前状态不支持下架"),

    OVER_PRODUCT_SHOW_IMG_AND_VID_MAX_COUNT(50005, "超过展示图片加视频最大上传数量"),

    OVER_PRODUCT_FEATURE_FIELD_MAX_LENGTH(50006, "超过产品特性字段最大长度"),

    PRODUCT_FEATURE_MATERIAL_NOT_EXIST(50007, "当前产品物料和特性信息不存在"),

    PRODUCT_NUTRITION_NOT_EXIST(50008, "当前产品营养信息不存在"),

    PRODUCT_NOT_SUPPORT_EDIT(50009, "当前状态不支持编辑"),

    PRODUCT_NOT_SUPPORT_DELETE(50010, "当前状态不支持删除"),

    READ_PRODUCT_EXCEL_ERROR(50011, "解析产品Excel异常"),

    PRODUCT_INFO_NOT_SUPPORT_PUBLISH(50012, "产品信息不完整无法发布"),

    PRODUCT_EN_NAME_DUPLICATE(50013, "产品英文名重复"),

    /**
     * 6____ 热点洞察管理
     */
    PLACEHOLDER_6(60000, "占位"),

    INSIGHT_NOT_EXIST(60001, "当前热点洞察不存在"),

    INSIGHT_NOT_SUPPORT_DELETE(60002, "当前热点洞察状态不支持删除"),

    INSIGHT_NOT_SUPPORT_LISTING(50003, "当前状态不支持发布"),

    INSIGHT_NOT_SUPPORT_DELISTED(50004, "当前状态不支持下架"),

    /**
     * 7____ 标签管理
     */
    TAG_GROUP_DUPLICATE(70001, "标签组已存在，请勿重复创建"),

    TAG_DUPLICATE(70002, "标签已存在，请勿重复创建"),

    TAG_GROUP_CANNOT_BELONG_TO_TAG(70003, "标签组不能创建在标签下"),

    TAG_CANNOT_BELONG_TO_TAG(70004, "标签不能创建在标签下"),

    TAG_GROUP_AND_TAG_CANNOT_IN_SAME_LEVEL(70005, "标签组与标签不能创建在同一层级"),

    CANNOT_EDIT_ENABLED_TAG(70006, "标签状态为已启用时不能编辑"),

    CANNOT_DELETE_ENABLED_TAG(70007, "标签状态为已启用时不能删除"),

    CANNOT_CHANGE_TAG_GROUP_STATUS(70008, "不能修改标签组状态"),

    CANNOT_CHANGE_TAG_GROUP_PARENT_ID(70009, "不能修改标签组父节点"),

    CANNOT_DELETE_CHANNEL_TAG_GROUP(70010, "不能删除市场渠道标签组"),

    CANNOT_EDIT_CHANNEL_TAG_GROUP(70011, "不能编辑市场渠道标签组"),

    /**
     * 8____ 用户管理
     */
    STATUS_IS_NOT_PENDING(80001, "状态不是待审核"),

    /**
     * 9____ 权限管理
     */
    USER_ROLE_DUPLICATE(90001, "一个用户只能分配一个角色"),

    /**
     * 10____ 评论管理
     */
    HIT_SENSITIVE_WORD(100001, "内容包含敏感词"),

    ONLY_CAN_PIN_ONE_COMMENT(100002, "只能置顶一条评论"),

    CANNOT_PIN_HIDDEN_COMMENT(100002, "不能置顶已隐藏的评论"),

    /**
     * 11____ 首页管理
     */
    PLACEHOLDER_11(110000, "占位"),

    BANNER_NOT_EXIST(110001, "当前BANNER不存在"),

    BANNER_NOT_SUPPORT_DELETE(60002, "当前BANNER状态不支持删除"),

    BANNER_NOT_SUPPORT_LISTING(50003, "当前状态不支持发布"),

    BANNER_NOT_SUPPORT_DELISTED(50004, "当前状态不支持下架"),

    BANNER_ORDER_NUMBER_CONFLICT(50005, "排序冲突，请求改当前排序后再提交"),

    BANNER_STATUS_NOT_SUPPORT_EDITION(50006, "当前状态不支持编辑"),

    BANNER_MORE_THAN_EIGHT(50007, "已超过8个限制数量，请删减后再提交"),

        ;

    private final Integer code;

    private final String message;
}

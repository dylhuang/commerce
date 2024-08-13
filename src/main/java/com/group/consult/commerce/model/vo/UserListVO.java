package com.group.consult.commerce.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @title: 用户列表
 * @description: 用户列表
 * @author: zl
 * @date: 2024-08-13
 */
@Data
@Schema(description = "用户列表")
public class UserListVO extends BaseVO{

    @Schema(description = "机构名称")
    private String orgName;

    @Schema(description = "用户号")
    private String userName ;

    @Schema(description = "昵称")
    private String nickName ;

    @Schema(description = "邮箱")
    private String email ;

    @Schema(description = "电话")
    private String phone ;

    @Schema(description = "性别（0男，1女）")
    private Integer gender ;

    @Schema(description = "备注")
    private String remark ;

    @Schema(description = "用户状态(0-正常，1-禁用)")
    private Integer status ;
}

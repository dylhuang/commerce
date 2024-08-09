package com.group.consult.commerce.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @title: 用户信息
 * @description: 用户信息
 * @author: zl
 * @date: 2024-08-09
 */
@Data
@Schema(description = "用户信息")
public class UserInfoVO {
    @Schema(description = "标识")
    private Long id ;

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

    @Schema(description = "创建时间")
    private Date createTime ;

    @Schema(description = "更新时间")
    private Date updateTime ;

    @Schema(description = "拥有的角色id列表")
    private List<String> roleIds;

    @Schema(description = "全数据-角色列表")
    private List<RoleVO> roleAllList;

    @Schema(description = "权限码列表")
    private List<String> permissionCodes;


}

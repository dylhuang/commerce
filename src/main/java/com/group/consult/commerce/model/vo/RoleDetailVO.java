package com.group.consult.commerce.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @title: 角色详情
 * @description: 角色详情
 * @author: zl
 * @date: 2024-08-12
 */
@Schema(description = "角色详情")
@Data
public class RoleDetailVO {


    @Schema(description = "标识")
    private String id;

    @Schema(description = "角色名称")
    private String roleName;

    @Schema(description = "角色编码")
    private String roleCode;

    @Schema(description = "备注")
    private String remark;

    @Schema(description = "创建时间")
    private Date createTime ;

    @Schema(description = "更新时间")
    private Date updateTime ;

    @Schema(description = "角色权限菜单")
    private List<String> menuIds;
}

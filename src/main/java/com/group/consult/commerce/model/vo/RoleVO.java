package com.group.consult.commerce.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

/**
 * @title: 角色
 * @description: 角色
 * @author: zl
 * @date: 2024-08-09
 */
@Data
@Schema(description = "角色")
public class RoleVO {
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
}

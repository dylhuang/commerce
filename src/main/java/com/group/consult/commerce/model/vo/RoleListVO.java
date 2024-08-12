package com.group.consult.commerce.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @title: 角色列表
 * @description: 角色列表
 * @author: zl
 * @date: 2024-08-12
 */
@Schema(description = "角色列表")
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
public class RoleListVO extends BaseVO{

    @Schema(description = "角色名称")
    private String roleName;

    @Schema(description = "角色编码")
    private String roleCode;

    @Schema(description = "备注")
    private String remark;

}

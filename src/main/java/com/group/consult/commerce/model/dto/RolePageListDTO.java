package com.group.consult.commerce.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @title: 角色分页查询
 * @description: 角色分页查询
 * @author: zl
 * @date: 2024-08-12
 */
@EqualsAndHashCode(callSuper = true)
@Schema(description = "角色分页查询")
@Data
public class RolePageListDTO extends PageRequestDTO{

    @Schema(description = "角色名称")
    private String roleName;

    @Schema(description = "角色编码")
    private String roleCode;
}

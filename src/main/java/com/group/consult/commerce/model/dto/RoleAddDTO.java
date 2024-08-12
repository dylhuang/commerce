package com.group.consult.commerce.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @title: 添加角色
 * @description: 添加角色
 * @author: zl
 * @date: 2024-08-12
 */
@Schema(description = "添加角色")
@Data
public class RoleAddDTO {

    @NotBlank(message = "角色名称必填")
    @Schema(description = "角色名称", required = true)
    private String roleName;

    @NotBlank(message = "角色编码必填")
    @Schema(description = "角色编码", required = true)
    private String roleCode;

    @Schema(description = "备注")
    private String remark;

    @Schema(description = "权限菜单列表")
    private List<String> menuIds = new ArrayList<>();
}

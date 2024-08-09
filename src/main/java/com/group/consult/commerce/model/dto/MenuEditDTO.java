package com.group.consult.commerce.model.dto;

import com.group.consult.commerce.model.enumeration.MenuTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * @title: 编辑菜单
 * @description: 菜单
 * @author: zl
 * @date: 2024-08-09
 */
@Data
public class MenuEditDTO {

    @Schema(description = "表示")
    private String id;

    @Schema(description = "父级标识")
    private String parentId = "0";

    @NotBlank(message = "菜单名称必填")
    @Schema(description = "菜单名称", required = true)
    private String menuName;

    @Schema(description = "权限标识")
    private String code;

    @Schema(description = "显示顺序")
    private Integer orderNum = 0;

    @Schema(description = "路径")
    private String path;

    @NotBlank(message = "路由名称必填")
    @Schema(description = "路由名称", required = true)
    private String routeName;

    @Schema(description = "组件")
    private String component;

    @Schema(description = "是否外链（0-否，1-是）")
    private Integer isLink = 0;

    @NotNull(message = "菜单类型必填")
    @Schema(description = "菜单类型（M目录 C菜单 F按钮）", required = true)
    private MenuTypeEnum menuType;

    @Schema(description = "是否启用（0-否，1-是）默认1")
    private Integer isEnable = 1;

    @Schema(description = "图标")
    private String icon;

    @Schema(description = "备注")
    private String remark;
}

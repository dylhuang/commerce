package com.group.consult.commerce.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @title: 分页菜单
 * @description: 分页菜单
 * @author: zl
 * @date: 2024-08-13
 */
@Data
@Schema(description = "分页菜单")
public class SysMenuPageListVO extends BaseVO{

    @Schema(description = "父级标识")
    private String parentId;

    @Schema(description = "菜单名称")
    private String menuName;

    @Schema(description = "权限标识")
    private String code;

    @Schema(description = "显示顺序")
    private Integer orderNum;

    @Schema(description = "路径")
    private String path;

    @Schema(description = "路由名称")
    private String routeName;

    @Schema(description = "组件")
    private String component;

    @Schema(description = "是否外链（0-否，1-是）")
    private Integer isLink;

    @Schema(description = "菜单类型（M目录 C菜单 F按钮）")
    private String menuType;

    @Schema(description = "是否启用（0-否，1-是）默认1")
    private Integer isEnable;

    @Schema(description = "图标")
    private String icon;

    @Schema(description = "备注")
    private String remark;
}

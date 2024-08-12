package com.group.consult.commerce.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

/**
 * @title: 菜单列表
 * @description: 菜单列表
 * @author: zl
 * @date: 2024-08-12
 */
@Data
@Schema(description = "菜单列表")
public class SysMenuListVO {


    @Schema(description = "标识")
    private String id;

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

    @Schema(description = "创建时间")
    private Date createTime ;

    @Schema(description = "更新时间")
    private Date updateTime ;
}

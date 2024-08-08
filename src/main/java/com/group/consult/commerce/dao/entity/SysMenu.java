package com.group.consult.commerce.dao.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author zl
 * @since 2024/08/08
 */
@Getter
@Setter
@TableName("sys_menu")
public class SysMenu extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 父级标识 */
    @TableField("parent_id")
    private Long parentId;

    /** 菜单名称 */
    @TableField("menu_name")
    private String menuName;

    /** 权限标识 */
    @TableField("code")
    private String code;

    /** 显示顺序 */
    @TableField("order_num")
    private Integer orderNum;

    /** 路径 */
    @TableField("path")
    private String path;

    /** 路由名称 */
    @TableField("route_name")
    private String routeName;

    /** 组件 */
    @TableField("component")
    private String component;

    /** 是否外链（0-否，1-是） */
    @TableField("is_link")
    private Integer isLink;

    /** 菜单类型（M目录 C菜单 F按钮） */
    @TableField("menu_type")
    private String menuType;

    /**  是否启用（0-否，1-是）默认1 */
    @TableField("is_enable")
    private Integer isEnable;

    /** 图标 */
    @TableField("icon")
    private String icon;

    /** 备注 */
    @TableField("remark")
    private String remark;

    /** 创建时间 */
    @TableField("create_time")
    private LocalDateTime createTime;

    /** 创建人 */
    @TableField("create_by")
    private String createBy;

    /** 更新时间 */
    @TableField("update_time")
    private LocalDateTime updateTime;

    /** 更新人 */
    @TableField("update_by")
    private String updateBy;

    /** 是否删除；0：未删除；1：删除 */
    @TableField("is_del")
    private Integer isDel;
}

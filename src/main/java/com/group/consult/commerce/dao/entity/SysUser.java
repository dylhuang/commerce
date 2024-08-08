package com.group.consult.commerce.dao.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

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
@TableName("sys_user")
public class SysUser extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 机构标识 */
    @TableField("org_id")
    private Long orgId;

    /** 用户号 */
    @TableField("user_name")
    private String userName;

    /** 密码 */
    @TableField("password")
    private String password;

    /** 盐值 */
    @TableField("salt_figure")
    private String saltFigure;

    /** 昵称 */
    @TableField("nick_name")
    private String nickName;

    /** 邮箱 */
    @TableField("email")
    private String email;

    /** 电话 */
    @TableField("phone")
    private String phone;

    /** 性别（0男，1女） */
    @TableField("gender")
    private Integer gender;

    /** 备注 */
    @TableField("remark")
    private String remark;

    /** 用户状态(0-正常，1-禁用) */
    @TableField("status")
    private Integer status;

}

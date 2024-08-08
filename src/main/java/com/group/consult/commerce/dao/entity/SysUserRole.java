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
@TableName("sys_user_role")
public class SysUserRole extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 用户id */
    @TableField("user_id")
    private Long userId;

    /** 角色id */
    @TableField("role_id")
    private Long roleId;

}

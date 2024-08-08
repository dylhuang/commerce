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
@TableName("sys_role")
public class SysRole extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;


    /** 角色名称 */
    @TableField("role_name")
    private String roleName;

    /** 角色编码 */
    @TableField("role_code")
    private String roleCode;

    /** 备注 */
    @TableField("remark")
    private String remark;

}

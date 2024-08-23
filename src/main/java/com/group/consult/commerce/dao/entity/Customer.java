package com.group.consult.commerce.dao.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>
 * 会员
 * </p>
 *
 * @author zl
 * @since 2024/08/22
 */
@Getter
@Setter
@TableName("customer")
public class Customer extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**会员编号 */
    @TableField("customer_no")
    private Long customerNo;

    /**用户名 */
    @TableField("user_name")
    private String userName;

    /**密码 */
    @TableField("password")
    private String password;

    /**电话 */
    @TableField("phone")
    private String phone;

    /**性别 */
    @TableField("gender")
    private String gender;

    /**用户角色：客户、机构、督导 */
    @TableField("user_role")
    private String userRole;

    /**状态：禁用、正常 */
    @TableField("status")
    private String status;

}

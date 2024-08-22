package com.group.consult.commerce.dao.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>
 * 会员个人资料
 * </p>
 *
 * @author zl
 * @since 2024/08/22
 */
@Getter
@Setter
@TableName("customer_profile")
public class CustomerProfile extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**会员编号 */
    @TableField("customer_no")
    private Long customerNo;

    /**手机号 */
    @TableField("phone")
    private String phone;

    /**身份证 */
    @TableField("id_no")
    private String idNo;

    /**真实姓名 */
    @TableField("real_name")
    private String realName;
}

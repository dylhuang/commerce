package com.group.consult.commerce.dao.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>
 * 会员权益
 * </p>
 *
 * @author zl
 * @since 2024/08/22
 */
@Getter
@Setter
@TableName("customer_rights")
public class CustomerRights extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 会员编号 */
    @TableField("customer_no")
    private Long customerNo;

    /** 积分 */
    @TableField("point")
    private Long point;

    /** 等级 */
    @TableField("level")
    private String level;

}

package com.group.consult.commerce.dao.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 商品表
 *
 * @author Huang, Dylan Bo
 * @since 2024/08/07
 */
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
@ToString
@TableName("merchandise")
public class Merchandise extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商品编码
     */
    @TableField("merchandise_code")
    private String merchandiseCode;

    /**
     * 商品名称
     */
    @TableField("merchandise_name")
    private String merchandiseName;

    /**
     * 商品状态 10:可销售  20:不可销售
     */
    @TableField("status")
    private String status;

    /**
     * To B价格：折扣价/日常单价
     */
    @TableField("business_price")
    private BigDecimal businessPrice;

    /**
     * To B价格是否可销售；0：不可销售；1：可销售
     */
    @TableField("business_enable")
    private Integer businessEnable;

    /**
     * To C价格：原价/活动单价
     */
    @TableField("customer_price")
    private BigDecimal customerPrice;

    /**
     * To C价格是否可销售；0：不可销售；1：可销售
     */
    @TableField("customer_enable")
    private Integer customerEnable;
}

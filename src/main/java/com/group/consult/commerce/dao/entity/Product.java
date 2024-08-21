package com.group.consult.commerce.dao.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 商品表
 *
 * @author Huang, Dylan Bo
 * @since 2024/08/20
 */
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
@ToString
@TableName("product")
public class Product extends BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = -3382339739410265164L;

    /**
     * 产品编码
     */
    @TableField("code")
    private String code;

    /**
     * 产品名称
     */
    @TableField("name")
    private String name;

    /**
     * 产品状态 10:待发布  20:已发布
     */
    @TableField("status")
    private String status;

    /**
     * 产品单价
     */
    @TableField("price")
    private BigDecimal price;
}

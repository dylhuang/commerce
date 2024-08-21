package com.group.consult.commerce.dao.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serial;
import java.io.Serializable;

/**
 * 商品服务表
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
@TableName("merchandise_product")
public class MerchandiseProduct extends BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = -4243769690429761139L;

    /**
     * 商品ID
     */
    @TableField("merchandise_id")
    private Long merchandiseId;

    /**
     * 产品ID
     */
    @TableField("product_id")
    private Long productId;

    /**
     * 产品个数
     */
    @TableField("product_number")
    private Integer productNumber;
}

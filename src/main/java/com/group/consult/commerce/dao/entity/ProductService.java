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
 * @since 2024/08/07
 */
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
@ToString
@TableName("product_service")
public class ProductService extends BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 2488573555398635945L;

    /**
     * 产品ID
     */
    @TableField("product_id")
    private Long productId;

    /**
     * 服务类型ID
     */
    @TableField("service_type_id")
    private Long serviceTypeId;
}

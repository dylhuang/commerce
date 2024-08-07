package com.group.consult.commerce.dao.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import lombok.experimental.SuperBuilder;

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
@TableName("merchandise_service")
public class MerchandiseService extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商品ID
     */
    @TableField("merchandise_id")
    private Long merchandiseId;

    /**
     * 服务类型ID
     */
    @TableField("service_type_id")
    private Long serviceTypeId;
}

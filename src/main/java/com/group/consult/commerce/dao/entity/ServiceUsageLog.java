package com.group.consult.commerce.dao.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>
 * 服务包使用记录
 * </p>
 *
 * @author zl
 * @since 2024/08/22
 */
@Getter
@Setter
@TableName("service_usage_log")
public class ServiceUsageLog extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 服务包编号 */
    @TableField("service_pack_no")
    private String servicePackNo;

    /** 所属订单编号 */
    @TableField("order_no")
    private String orderNo;

    /** 产品id */
    @TableField("product_id")
    private Long productId;

    /** 调整前数量 */
    @TableField("before_num")
    private Integer beforeNum;

    /** 使用数量 */
    @TableField("num")
    private Integer num;

    /** 调整后数量 */
    @TableField("after_num")
    private Integer afterNum;

    /** 调整方向：调增、调减 */
    @TableField("direction")
    private String direction;

    /** 类型：退单、兑换、划转、报单 */
    @TableField("usage_type")
    private String usageType;
}

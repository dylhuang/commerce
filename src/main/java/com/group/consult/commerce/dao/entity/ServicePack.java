package com.group.consult.commerce.dao.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 服务包
 * </p>
 *
 * @author zl
 * @since 2024/08/22
 */
@Getter
@Setter
@TableName("service_pack")
public class ServicePack extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 服务包编号 */
    @TableField("service_pack_no")
    private String servicePackNo;

    /** 所属订单编号 */
    @TableField("order_no")
    private String orderNo;

    /** 持包人id */
    @TableField("hold_customer_id")
    private Long holdCustomerId;

    /** 产品id */
    @TableField("product_id")
    private Long productId;

    /** 冗余字段，产品名称 */
    @TableField("product_name")
    private String productName;

    /** 购买的数量。固定不变，订单实际应发数量 */
    @TableField("buy_num")
    private Integer buyNum;

    /** 剩余数量 */
    @TableField("remain_num")
    private Integer remainNum;

    /** 状态：初始化、已完成 */
    @TableField("status")
    private String status;

    /** 完成时间 */
    @TableField("finish_time")
    private LocalDateTime finishTime;
}

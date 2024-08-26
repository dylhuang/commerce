package com.group.consult.commerce.model.vo;

import com.group.consult.commerce.model.enumeration.OrderSourceTypeEnum;
import com.group.consult.commerce.model.enumeration.OrderStatusEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @title: 订单查询
 * @description: 订单查询
 * @author: zl
 * @date: 2024-08-23
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Schema(description = "订单查询")
public class OrderPageListVO extends BaseVO{

    @Schema(description = "订单编号")
    private String orderNo;

    @Schema(description = "会员id")
    private String customerId;

    @Schema(description = "会员编号")
    private String customerNo;

    @Schema(description = "订单金额")
    private BigDecimal amount;

    @Schema(description = "支付金额")
    private BigDecimal payAmount;

    @Schema(description = "商品Id")
    private String merchandiseId;

    @Schema(description = "商品类型")
    private String merchandiseType;

    @Schema(description = "订单状态：待支付、已支付、已关闭、已完成、部分退款、全额退款")
    private OrderStatusEnum status;

    @Schema(description = "已退款金额")
    private BigDecimal refundedAmount;

    @Schema(description = "单价")
    private BigDecimal unitPrice;

    @Schema(description = "数量")
    private Integer num;

    @Schema(description = "支付时间")
    private LocalDateTime payTime;

    @Schema(description = "完成时间")
    private LocalDateTime finishTime;

    @Schema(description = "订单来源类型")
    private OrderSourceTypeEnum sourceType;

    @Schema(description = "订单来源标识")
    private String sourceNo;

    @Schema(description = "备注")
    private String remark;
}

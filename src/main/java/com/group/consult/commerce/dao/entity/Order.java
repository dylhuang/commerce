package com.group.consult.commerce.dao.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 订单表
 * </p>
 *
 * @author zl
 * @since 2024/08/22
 */
@Getter
@Setter
@TableName("order")
public class Order extends BaseEntity  implements Serializable {

    private static final long serialVersionUID = 1L;

    /**订单编号*/
    @TableField("order_no")
    private String orderNo;

    /**会员id*/
    @TableField("customer_id")
    private Long customerId;

    /**会员编号*/
    @TableField("customer_no")
    private Long customerNo;

    /**订单金额*/
    @TableField("amount")
    private BigDecimal amount;

    /**支付金额*/
    @TableField("pay_amount")
    private BigDecimal payAmount;

    /**商品Id*/
    @TableField("merchandise_id")
    private Long merchandiseId;

    /**商品类型（区别不同也业务，执行不同的业务逻辑，来自商品表，冗余字段）*/
    @TableField("merchandise_type")
    private String merchandiseType;

    /**订单状态：待支付、已支付、已关闭、部分退款、全额退款*/
    @TableField("status")
    private String status;

    /**已退款金额*/
    @TableField("refunded_amount")
    private BigDecimal refundedAmount;

    /**单价*/
    @TableField("unit_price")
    private BigDecimal unitPrice;

    /**数量*/
    @TableField("num")
    private Integer num;

    /**支付时间*/
    @TableField("pay_time")
    private LocalDateTime payTime;

    /**完成时间*/
    @TableField("finish_time")
    private LocalDateTime finishTime;

    /**备注*/
    @TableField("remark")
    private String remark;
}

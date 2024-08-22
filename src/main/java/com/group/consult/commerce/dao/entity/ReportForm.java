package com.group.consult.commerce.dao.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 报单
 * </p>
 *
 * @author zl
 * @since 2024/08/22
 */
@Getter
@Setter
@TableName("report_form")
public class ReportForm extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 报单编号 */
    @TableField("report_no")
    private String reportNo;

    /** 服务包编号 */
    @TableField("service_pack_no")
    private String servicePackNo;

    /** 持包人id */
    @TableField("hold_customer_id")
    private Long holdCustomerId;

    /** 使用数量 */
    @TableField("usage_num")
    private Integer usageNum;

    /** 持包产品id */
    @TableField("hold_product_id")
    private Long holdProductId;

    /** 报单时间 */
    @TableField("report_time")
    private LocalDateTime reportTime;

    /** 退单时间 */
    @TableField("back_time")
    private LocalDateTime backTime;

    /** 状态：初始化、审核中、已拒绝、已完成、已退单 */
    @TableField("report_status")
    private String reportStatus;
}

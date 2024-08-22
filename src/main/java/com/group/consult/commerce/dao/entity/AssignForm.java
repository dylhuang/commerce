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
 * 案件派单
 * </p>
 *
 * @author zl
 * @since 2024/08/22
 */
@Getter
@Setter
@TableName("assign_form")
public class AssignForm extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 派单编号 */
    @TableField("assign_no")
    private String assignNo;

    /** 报单编号 */
    @TableField("report_no")
    private String reportNo;

    /** 委托人姓名 */
    @TableField("entrust_name")
    private String entrustName;

    /** 委托人手机 */
    @TableField("entrust_phone")
    private String entrustPhone;

    /** 委托人性别 */
    @TableField("entrust_gender")
    private String entrustGender;

    /** 委托人身份证 */
    @TableField("entrust_id_no")
    private String entrustIdNo;

    /** 委托业务类别 */
    @TableField("entrust_biz_type")
    private String entrustBizType;

    /** 委托业务需求 */
    @TableField("entrust_biz_need")
    private String entrustBizNeed;

    /** 处理机构 */
    @TableField("handle_org")
    private String handleOrg;

    /** 债务金额，单位元 */
    @TableField("det_amount")
    private BigDecimal detAmount;

    /** 服务进度/状态：待服务、资料审核中、服务进行中、服务暂停、服务结案、拒绝 */
    @TableField("assign_status")
    private String assignStatus;

    /** 接单法务公司 */
    @TableField("law_org")
    private String lawOrg;

    /** 服务人员 */
    @TableField("service_man")
    private String serviceMan;

    /** 拒绝理由 */
    @TableField("reject_reason")
    private String rejectReason;

    /** 结案日期 */
    @TableField("finish_time")
    private LocalDateTime finishTime;

    /** 结案证明 */
    @TableField("finish_prove")
    private String finishProve;

}

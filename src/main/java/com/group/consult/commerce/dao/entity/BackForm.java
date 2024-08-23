package com.group.consult.commerce.dao.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>
 * 退单
 * </p>
 *
 * @author zl
 * @since 2024/08/22
 */
@Getter
@Setter
@TableName("back_form")
public class BackForm extends BaseEntity  implements Serializable {

    private static final long serialVersionUID = 1L;

    /**退单编号 */
    @TableField("back_no")
    private String backNo;

    /**原报单编号 */
    @TableField("report_no")
    private String reportNo;

    /**退单理由 */
    @TableField("reason")
    private String reason;

    /**审核中、已退单 */
    @TableField("back_status")
    private String backStatus;

}

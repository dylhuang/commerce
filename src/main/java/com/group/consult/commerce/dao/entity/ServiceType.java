package com.group.consult.commerce.dao.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

/**
 * <p>
 * 服务类型表
 * </p>
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
@TableName("service_type")
public class ServiceType extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 服务类型名称
     */
    @TableField("service_type_name")
    private String serviceTypeName;

    /**
     * 服务类型状态 10:可用  20:不可用
     */
    @TableField("service_type_status")
    private String serviceTypeStatus;
}

package com.group.consult.commerce.model.vo;

import com.group.consult.commerce.dao.entity.Merchandise;
import com.group.consult.commerce.dao.entity.ServiceType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 服务类型VO
 *
 * @author Huang, Dylan Bo
 * @since 2024/08/12
 */
@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ServiceTypeVO extends BaseVO implements Serializable {

    @Serial
    private static final long serialVersionUID = -7931415515062439191L;

    /**
     * 服务类型名称
     */
    @Schema(description = "服务类型名称")
    private String serviceTypeName;

    /**
     * 服务类型状态 10:可用  20:不可用
     */
    @Schema(description = "服务类型状态 10:可用  20:不可用")
    private String serviceTypeStatus;

    public static ServiceTypeVO of(ServiceType serviceType) {
        return ServiceTypeVO.builder()
                .id(serviceType.getId())
                .serviceTypeName(serviceType.getServiceTypeName())
                .serviceTypeStatus(serviceType.getServiceTypeStatus())
                .createBy(serviceType.getCreateBy())
                .createTime(serviceType.getCreateTime())
                .updateBy(serviceType.getUpdateBy())
                .updateTime(serviceType.getUpdateTime())
                .build();
    }
}

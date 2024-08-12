package com.group.consult.commerce.model.dto;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ServiceTypeEditionDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -7628758293738769955L;

    /**
     * 服务类型ID
     */
    private Long serviceTypeId;
    /**
     * 服务类型名称
     */
    private String serviceTypeName;

    /**
     * 服务类型状态 10:可用  20:不可用
     */
    private String serviceTypeStatus;

}
package com.group.consult.commerce.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Schema(description = "服务类型查询DTO")
public class ServiceTypeSearchDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 9172318387582287361L;

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
}

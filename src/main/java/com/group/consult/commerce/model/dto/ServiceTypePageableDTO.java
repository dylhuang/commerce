package com.group.consult.commerce.model.dto;

import com.group.consult.commerce.model.PageRequest;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
@Schema(description = "商品分页查询DTO")
public class ServiceTypePageableDTO extends PageRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = 8868006936661704367L;

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

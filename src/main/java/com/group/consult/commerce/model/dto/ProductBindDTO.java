package com.group.consult.commerce.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * 服务类型DTO
 *
 * @author Huang, Dylan Bo
 * @since 2024/08/12
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductBindDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -7931415515062439191L;

    /**
     * 服务类型名称
     */
    @Schema(description = "产品ID")
    private Long productId;

    /**
     * 服务类型名称
     */
    @Schema(description = "服务类型ID")
    private List<Long> serviceTypeIdList;
}

package com.group.consult.commerce.model.dto;

import com.group.consult.commerce.model.vo.BaseVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.SuperBuilder;

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
public class MerchandiseBindDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -7931415515062439191L;

    /**
     * 服务类型名称
     */
    @Schema(description = "商品ID")
    private Long merchandiseId;

    /**
     * 服务类型名称
     */
    @Schema(description = "服务类型ID")
    private List<Long> serviceTypeIdList;
}

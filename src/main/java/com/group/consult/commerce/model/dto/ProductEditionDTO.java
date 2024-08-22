package com.group.consult.commerce.model.dto;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductEditionDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -2485354702614339759L;

    /**
     * 产品ID
     */
    private Long productId;

    /**
     * 产品名称
     */
    private String merchandiseName;

    /**
     * 产品单价
     */
    private BigDecimal price;

    /**
     * 服务类型ID列表
     */
    private List<Long> serviceTypeIdList;
}
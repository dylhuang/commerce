package com.group.consult.commerce.model.dto;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductAdditionDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 2911790811124592986L;

    /**
     * 产品名称
     */
    private String name;

    /**
     * 产品单价
     */
    private BigDecimal price;

}
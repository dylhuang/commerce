package com.group.consult.commerce.model.dto;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MerchandiseProductRelationDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -3898056727651164521L;

    /**
     * 产品名称
     */
    private Long productId;

    /**
     * 产品个数
     */
    private Integer productNumber;
}
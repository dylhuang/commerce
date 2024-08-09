package com.group.consult.commerce.model.dto;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

public class MerchandiseEditionDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -2865596965693545276L;

    /**
     * 商品ID
     */
    private Long merchandiseId;

    /**
     * 商品名称
     */
    private String merchandiseName;

    /**
     * To B价格：折扣价/日常单价
     */
    private BigDecimal businessPrice;

    /**
     * To B价格是否可销售；0：不可销售；1：可销售
     */
    private Integer businessEnable;

    /**
     * To C价格：原价/活动单价
     */
    private BigDecimal customerPrice;

    /**
     * To C价格是否可销售；0：不可销售；1：可销售
     */
    private Integer customerEnable;
}
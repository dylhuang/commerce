package com.group.consult.commerce.model.dto;

import com.group.consult.commerce.model.PageRequest;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @title: 订单列表
 * @description: 订单列表
 * @author: zl
 * @date: 2024-08-23
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Schema(description = "订单列表")
public class OrderListDTO extends PageRequest {

    @Schema(description = "订单编号")
    private String orderNo;

    @Schema(description = "会员编号")
    private String customerNo;

    @Schema(description = "来源标识")
    private String sourceNo;

}

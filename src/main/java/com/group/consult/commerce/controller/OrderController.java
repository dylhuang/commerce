package com.group.consult.commerce.controller;

import com.group.consult.commerce.model.ApiResult;
import com.group.consult.commerce.model.PageResult;
import com.group.consult.commerce.model.dto.OrderListDTO;
import com.group.consult.commerce.model.vo.OrderDetailVO;
import com.group.consult.commerce.model.vo.OrderPageListVO;
import com.group.consult.commerce.service.IOrderDomainService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @title: 订单管理
 * @description: 订单管理
 * @author: zl
 * @date: 2024-08-23
 */
@RestController
@RequestMapping("/api/sys/order")
public class OrderController {

    @Autowired
    private IOrderDomainService orderDomainService;

    @Operation(summary = "订单分页列表")
    @PostMapping("/pageList")
    public ApiResult<PageResult<OrderPageListVO>> pageList(@RequestBody OrderListDTO dto) {
        return ApiResult.success(orderDomainService.pageList(dto));
    }

    @Operation(summary = "订单详情")
    @GetMapping("/fetchDetail")
    public ApiResult<OrderDetailVO> fetchDetail(@RequestParam("id") Long id) {
        return ApiResult.success(orderDomainService.fetchDetail(id));
    }
}

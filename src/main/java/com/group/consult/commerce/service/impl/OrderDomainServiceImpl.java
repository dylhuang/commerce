package com.group.consult.commerce.service.impl;

import com.group.consult.commerce.model.PageResult;
import com.group.consult.commerce.model.dto.OrderListDTO;
import com.group.consult.commerce.model.vo.OrderDetailVO;
import com.group.consult.commerce.model.vo.OrderPageListVO;
import com.group.consult.commerce.persist.IOrderService;
import com.group.consult.commerce.service.IOrderDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @title: 订单管理
 * @description: 订单管理
 * @author: zl
 * @date: 2024-08-23
 */
@Service
public class OrderDomainServiceImpl implements IOrderDomainService {

    @Autowired
    private IOrderService orderService;

    @Override
    public PageResult<OrderPageListVO> pageList(OrderListDTO dto) {
        return orderService.pageList(dto);
    }

    @Override
    public OrderDetailVO fetchDetail(Long id) {
        return orderService.fetchDetail(id);
    }
}

package com.group.consult.commerce.service;

import com.group.consult.commerce.model.PageResult;
import com.group.consult.commerce.model.dto.OrderListDTO;
import com.group.consult.commerce.model.vo.OrderDetailVO;
import com.group.consult.commerce.model.vo.OrderPageListVO;

public interface IOrderDomainService {

    /**
     * 订单分页查询
     * @param dto
     * @return
     */
    PageResult<OrderPageListVO> pageList(OrderListDTO dto);

    /**
     * 订单详情
     * @param id
     * @return
     */
    OrderDetailVO fetchDetail(Long id);
}

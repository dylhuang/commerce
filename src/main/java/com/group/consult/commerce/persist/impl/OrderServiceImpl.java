package com.group.consult.commerce.persist.impl;

import com.group.consult.commerce.dao.entity.Order;
import com.group.consult.commerce.dao.mapper.OrderMapper;
import com.group.consult.commerce.persist.IOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author zl
 * @since 2024/08/22
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

}

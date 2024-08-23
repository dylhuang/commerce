package com.group.consult.commerce.persist.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.group.consult.commerce.dao.entity.OrdOrder;
import com.group.consult.commerce.dao.mapper.OrdOrderMapper;
import com.group.consult.commerce.model.PageResult;
import com.group.consult.commerce.model.dto.OrderListDTO;
import com.group.consult.commerce.model.vo.OrderDetailVO;
import com.group.consult.commerce.model.vo.OrderPageListVO;
import com.group.consult.commerce.persist.IOrderService;
import com.group.consult.commerce.utils.SqlUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author zl
 * @since 2024/08/22
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrdOrderMapper, OrdOrder> implements IOrderService {

    @Override
    public PageResult<OrderPageListVO> pageList(OrderListDTO dto) {
        LambdaQueryWrapper<OrdOrder> wrapper = Wrappers.lambdaQuery();
        if (StringUtils.isNotBlank(dto.getOrderNo())) {
            wrapper.eq(OrdOrder::getOrderNo, dto.getOrderNo());
        }
        if (StringUtils.isNotBlank(dto.getCustomerNo())) {
            wrapper.eq(OrdOrder::getCustomerNo, dto.getCustomerNo());
        }
        dto.initWithUpdateTimeSort();
        SqlUtils.commonOrderBy(dto.getSorts(), wrapper);
        Page<OrdOrder> page = this.page(Page.of(dto.getPageNum(), dto.getPageSize()), wrapper);
        List<OrderPageListVO> list = page.getRecords().stream().map(item -> {
            OrderPageListVO pageListVO = new OrderPageListVO();
            BeanUtil.copyProperties(item, pageListVO);
            return pageListVO;
        }).collect(Collectors.toList());

        return PageResult.of(list, page);
    }

    @Override
    public OrderDetailVO fetchDetail(Long id) {
        OrdOrder order = this.getById(id);
        if (order == null) {
            return null;
        }
        OrderDetailVO orderDetailVO = new OrderDetailVO();
        BeanUtil.copyProperties(order, orderDetailVO);

        return orderDetailVO;
    }
}

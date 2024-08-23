package com.group.consult.commerce.persist;

import com.group.consult.commerce.dao.entity.OrdOrder;
import com.baomidou.mybatisplus.extension.service.IService;
import com.group.consult.commerce.model.PageResult;
import com.group.consult.commerce.model.dto.OrderListDTO;
import com.group.consult.commerce.model.vo.OrderDetailVO;
import com.group.consult.commerce.model.vo.OrderPageListVO;

/**
 * <p>
 * 订单表 服务类
 * </p>
 *
 * @author zl
 * @since 2024/08/22
 */
public interface IOrderService extends IService<OrdOrder> {

    /**
     * 订单分页查询
     * @param dto
     * @return
     */
    PageResult<OrderPageListVO> pageList(OrderListDTO dto);

    /**
     * 获取详情
     * @param id
     * @return
     */
    OrderDetailVO fetchDetail(Long id);

}

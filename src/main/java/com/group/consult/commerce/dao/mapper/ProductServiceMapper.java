package com.group.consult.commerce.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.group.consult.commerce.dao.entity.ProductService;

/**
 * 商品服务表 Mapper 接口
 *
 * @author Huang, Dylan Bo
 * @since 2024/08/07
 */
public interface ProductServiceMapper extends BaseMapper<ProductService> {
    int removeByProductId(Long productId);
}

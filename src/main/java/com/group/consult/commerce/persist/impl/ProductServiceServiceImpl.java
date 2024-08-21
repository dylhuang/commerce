package com.group.consult.commerce.persist.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.group.consult.commerce.dao.entity.ProductService;
import com.group.consult.commerce.dao.mapper.ProductServiceMapper;
import com.group.consult.commerce.exception.BusinessException;
import com.group.consult.commerce.model.ApiCodeEnum;
import com.group.consult.commerce.persist.IProductServiceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 产品服务表 服务实现类
 *
 * @author Huang, Dylan Bo
 * @since 2024/08/07
 */
@Slf4j
@Service
public class ProductServiceServiceImpl extends ServiceImpl<ProductServiceMapper, ProductService> implements IProductServiceService {

    @Override
    public boolean batchInsertProductService(List<ProductService> productServiceList) throws BusinessException {
        try {
            return this.saveBatch(productServiceList);
        } catch (Exception e) {
            throw new BusinessException(ApiCodeEnum.SYSTEM_ERROR, e.getMessage());
        }
    }

    @Override
    public void deleteBindByProductId(Long productId) throws BusinessException {
        try {
            int i = this.baseMapper.removeByMerchandiseId(productId);
            if (i > 0) {
                log.info("成功清除商品和服务类型的绑定关系");
            }
        } catch (Exception e) {
            throw new BusinessException(ApiCodeEnum.SYSTEM_ERROR, e.getMessage());
        }
    }

    @Override
    public List<ProductService> getServiceTypeListByProductId(Long productId) throws BusinessException {
        try {
            LambdaQueryWrapper<ProductService> wrapper = new LambdaQueryWrapper<ProductService>()
                    .eq(ProductService::getProductId, productId)
                    .eq(ProductService::getIsDel, 0);
            return this.list(wrapper);
        } catch (Exception e) {
            throw new BusinessException(ApiCodeEnum.SYSTEM_ERROR, e.getMessage());
        }
    }

    @Override
    public List<Long> getServiceTypeIdListByProductId(Long productId) throws BusinessException {
        List<ProductService> entityList = this.getServiceTypeListByProductId(productId);
        return entityList.stream()
                .map(ProductService::getServiceTypeId)
                .toList();
    }
}

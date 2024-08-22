package com.group.consult.commerce.persist.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.group.consult.commerce.dao.entity.MerchandiseProduct;
import com.group.consult.commerce.dao.entity.ProductService;
import com.group.consult.commerce.dao.mapper.ProductServiceMapper;
import com.group.consult.commerce.exception.BusinessException;
import com.group.consult.commerce.model.ApiCodeEnum;
import com.group.consult.commerce.persist.IProductServiceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    ProductServiceMapper productServiceMapper;

    @Override
    public boolean batchInsertProductService(List<ProductService> productServiceList) throws BusinessException {
        try {
            return this.saveBatch(productServiceList);
        } catch (Exception e) {
            throw new BusinessException(ApiCodeEnum.SYSTEM_ERROR, e.getMessage());
        }
    }

    @Override
    public void deleteRelationByProductId(Long productId) throws BusinessException {

        try {
            LambdaQueryWrapper<ProductService> queryWrapper = Wrappers.lambdaQuery();
            queryWrapper.eq(ProductService::getProductId, productId);
            int rowsAffected = productServiceMapper.delete(queryWrapper);
            if (rowsAffected > 0) {
                log.info("成功清除产品和服务类型的关系：{} 条记录被清除", rowsAffected);
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

    @Override
    public boolean existRelationByServiceTypeId(Long serviceTypeId) throws BusinessException {
        try {
            LambdaQueryWrapper<ProductService> wrapper = new LambdaQueryWrapper<ProductService>()
                    .eq(ProductService::getServiceTypeId, serviceTypeId)
                    .eq(ProductService::getIsDel, 0);
            return this.exists(wrapper);
        } catch (Exception e) {
            throw new BusinessException(ApiCodeEnum.SYSTEM_ERROR, e.getMessage());
        }
    }
}

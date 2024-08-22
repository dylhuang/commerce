package com.group.consult.commerce.persist.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.group.consult.commerce.dao.entity.MerchandiseProduct;
import com.group.consult.commerce.dao.entity.ProductService;
import com.group.consult.commerce.dao.mapper.MerchandiseProductMapper;
import com.group.consult.commerce.exception.BusinessException;
import com.group.consult.commerce.model.ApiCodeEnum;
import com.group.consult.commerce.persist.IMerchandiseProductService;
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
public class MerchandiseProductServiceImpl extends ServiceImpl<MerchandiseProductMapper, MerchandiseProduct> implements IMerchandiseProductService {

    @Autowired
    MerchandiseProductMapper merchandiseProductMapper;

    @Override
    public boolean batchInsertMerchandiseProduct(List<MerchandiseProduct> merchandiseProductList) throws BusinessException {
        try {
            return this.saveBatch(merchandiseProductList);
        } catch (Exception e) {
            throw new BusinessException(ApiCodeEnum.SYSTEM_ERROR, e.getMessage());
        }
    }

    @Override
    public void deleteRelationByMerchandiseId(Long merchandiseId) throws BusinessException {

        try {
            LambdaQueryWrapper<MerchandiseProduct> queryWrapper = Wrappers.lambdaQuery();

            queryWrapper.eq(MerchandiseProduct::getMerchandiseId, merchandiseId);

            int rowsAffected = merchandiseProductMapper.delete(queryWrapper);

            System.out.println(rowsAffected + " ============= records deleted.");
        } catch (Exception e) {
            throw new BusinessException(ApiCodeEnum.SYSTEM_ERROR, e.getMessage());
        }
    }

    @Override
    public List<MerchandiseProduct> getMerchandiseProductListByMerchandiseId(Long merchandiseId) throws BusinessException {
        try {
            LambdaQueryWrapper<MerchandiseProduct> wrapper = new LambdaQueryWrapper<MerchandiseProduct>()
                    .eq(MerchandiseProduct::getMerchandiseId, merchandiseId)
                    .eq(MerchandiseProduct::getIsDel, 0);
            return this.list(wrapper);
        } catch (Exception e) {
            throw new BusinessException(ApiCodeEnum.SYSTEM_ERROR, e.getMessage());
        }
    }

    @Override
    public List<Long> getProductIdListByMerchandiseId(Long merchandiseId) throws BusinessException {
        List<MerchandiseProduct> entityList = this.getMerchandiseProductListByMerchandiseId(merchandiseId);
        return entityList.stream()
                .map(MerchandiseProduct::getProductId)
                .toList();
    }

    @Override
    public boolean existRelationByProductId(Long productId) throws BusinessException {
        try {
            LambdaQueryWrapper<MerchandiseProduct> wrapper = new LambdaQueryWrapper<MerchandiseProduct>()
                    .eq(MerchandiseProduct::getProductId, productId)
                    .eq(MerchandiseProduct::getIsDel, 0);
            return this.exists(wrapper);
        } catch (Exception e) {
            throw new BusinessException(ApiCodeEnum.SYSTEM_ERROR, e.getMessage());
        }
    }
}

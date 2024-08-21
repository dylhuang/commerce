package com.group.consult.commerce.persist.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.group.consult.commerce.dao.entity.MerchandiseProduct;
import com.group.consult.commerce.dao.entity.Product;
import com.group.consult.commerce.dao.entity.ProductService;
import com.group.consult.commerce.dao.mapper.MerchandiseProductMapper;
import com.group.consult.commerce.dao.mapper.ProductServiceMapper;
import com.group.consult.commerce.exception.BusinessException;
import com.group.consult.commerce.model.ApiCodeEnum;
import com.group.consult.commerce.persist.IMerchandiseProductService;
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
public class MerchandiseProductServiceImpl extends ServiceImpl<MerchandiseProductMapper, MerchandiseProduct> implements IMerchandiseProductService {

    @Override
    public boolean batchInsertMerchandiseProduct(List<MerchandiseProduct> merchandiseProductList) throws BusinessException {
        try {
            return this.saveBatch(merchandiseProductList);
        } catch (Exception e) {
            throw new BusinessException(ApiCodeEnum.SYSTEM_ERROR, e.getMessage());
        }
    }

    @Override
    public void deleteBindByMerchandiseId(Long merchandiseId) throws BusinessException {
        try {
            int i = 0;
            //this.baseMapper.removeByMerchandiseId(productId);
            if (i > 0) {
                log.info("成功清除商品和服务类型的绑定关系");
            }
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
}

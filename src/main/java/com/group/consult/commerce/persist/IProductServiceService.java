package com.group.consult.commerce.persist;

import com.baomidou.mybatisplus.extension.service.IService;
import com.group.consult.commerce.dao.entity.ProductService;
import com.group.consult.commerce.exception.BusinessException;

import java.util.List;

/**
 * <p>
 * 商品服务表 服务类
 * </p>
 *
 * @author Huang, Dylan Bo
 * @since 2024/08/07
 */
public interface IProductServiceService extends IService<ProductService> {

    /**
     * 批量插入商品-服务类型
     *
     * @param productServiceList List<ProductService>
     * @return boolean
     * @throws BusinessException BusinessException
     */
    boolean batchInsertProductService(List<ProductService> productServiceList) throws BusinessException;

    /**
     * 清除商品和服务类型的绑定关系
     *
     * @param productId Long
     * @throws BusinessException BusinessException
     */
    void deleteBindByProductId(Long productId) throws BusinessException;

    /**
     * 根据productId获取serviceTypeId列表
     *
     * @param productId productId
     * @return List<ProductService>
     * @throws BusinessException BusinessException
     */
    List<ProductService> getServiceTypeListByProductId(Long productId) throws BusinessException;

    /**
     * 根据merchandiseId获取serviceTypeId列表
     *
     * @param productId merchandiseId
     * @return List<Long>
     * @throws BusinessException BusinessException
     */
    List<Long> getServiceTypeIdListByProductId(Long productId) throws BusinessException;
}

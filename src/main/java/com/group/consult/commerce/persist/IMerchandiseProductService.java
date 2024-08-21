package com.group.consult.commerce.persist;

import com.baomidou.mybatisplus.extension.service.IService;
import com.group.consult.commerce.dao.entity.MerchandiseProduct;
import com.group.consult.commerce.dao.entity.Product;
import com.group.consult.commerce.dao.entity.ProductService;
import com.group.consult.commerce.exception.BusinessException;

import java.util.List;

/**
 * <p>
 * 商品服务表 服务类
 * </p>
 *
 * @author Huang, Dylan Bo
 * @since 2024/08/20
 */
public interface IMerchandiseProductService extends IService<MerchandiseProduct> {

    /**
     * 批量插入商品-产品
     *
     * @param merchandiseProductList List<MerchandiseProduct>
     * @return boolean
     * @throws BusinessException BusinessException
     */
    boolean batchInsertMerchandiseProduct(List<MerchandiseProduct> merchandiseProductList) throws BusinessException;

    /**
     * 清除商品和产品的绑定关系
     *
     * @param merchandiseId Long
     * @throws BusinessException BusinessException
     */
    void deleteBindByMerchandiseId(Long merchandiseId) throws BusinessException;

    /**
     * 根据merchandiseId获取商品产品列表
     *
     * @param merchandiseId merchandiseId
     * @return List<MerchandiseProduct>
     * @throws BusinessException BusinessException
     */
    List<MerchandiseProduct> getMerchandiseProductListByMerchandiseId(Long merchandiseId) throws BusinessException;

    /**
     * 根据merchandiseId获取产品ID列表
     *
     * @param merchandiseId merchandiseId
     * @return List<Long>
     * @throws BusinessException BusinessException
     */
    List<Long> getProductIdListByMerchandiseId(Long merchandiseId) throws BusinessException;
}

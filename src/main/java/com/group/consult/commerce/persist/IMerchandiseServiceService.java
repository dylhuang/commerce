package com.group.consult.commerce.persist;

import com.baomidou.mybatisplus.extension.service.IService;
import com.group.consult.commerce.dao.entity.MerchandiseService;
import com.group.consult.commerce.exception.BusinessException;

import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 * 商品服务表 服务类
 * </p>
 *
 * @author Huang, Dylan Bo
 * @since 2024/08/07
 */
public interface IMerchandiseServiceService extends IService<MerchandiseService> {

    /**
     * 批量插入商品-服务类型
     *
     * @param merchandiseServiceList List<MerchandiseService>
     * @return boolean
     * @throws BusinessException BusinessException
     */
    boolean batchInsertMerchandiseService(List<MerchandiseService> merchandiseServiceList) throws BusinessException;

    /**
     * 清除商品和服务类型的绑定关系
     *
     * @param merchandiseId Long
     * @throws BusinessException BusinessException
     */
    void deleteBindByMerchandiseId(Long merchandiseId) throws BusinessException;

    /**
     * 根据merchandiseId获取serviceTypeId列表
     *
     * @param merchandiseId merchandiseId
     * @return List<MerchandiseService>
     * @throws BusinessException BusinessException
     */
    List<MerchandiseService> getServiceTypeListByMerchandiseId(Long merchandiseId) throws BusinessException;

    /**
     * 根据merchandiseId获取serviceTypeId列表
     *
     * @param merchandiseId merchandiseId
     * @return List<Long>
     * @throws BusinessException BusinessException
     */
    List<Long> getServiceTypeIdListByMerchandiseId(Long merchandiseId) throws BusinessException;
}

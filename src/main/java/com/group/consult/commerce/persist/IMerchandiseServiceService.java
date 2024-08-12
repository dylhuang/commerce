package com.group.consult.commerce.persist;

import com.baomidou.mybatisplus.extension.service.IService;
import com.group.consult.commerce.dao.entity.MerchandiseService;
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
}

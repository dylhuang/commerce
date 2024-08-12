package com.group.consult.commerce.persist.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.group.consult.commerce.dao.entity.MerchandiseService;
import com.group.consult.commerce.dao.mapper.MerchandiseServiceMapper;
import com.group.consult.commerce.exception.BusinessException;
import com.group.consult.commerce.model.ApiCodeEnum;
import com.group.consult.commerce.persist.IMerchandiseServiceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品服务表 服务实现类
 *
 * @author Huang, Dylan Bo
 * @since 2024/08/07
 */
@Slf4j
@Service
public class MerchandiseServiceServiceImpl extends ServiceImpl<MerchandiseServiceMapper, MerchandiseService> implements IMerchandiseServiceService {

    @Override
    public boolean batchInsertMerchandiseService(List<MerchandiseService> merchandiseServiceList) throws BusinessException {
        try {
            return this.saveBatch(merchandiseServiceList);
        } catch (Exception e) {
            throw new BusinessException(ApiCodeEnum.SYSTEM_ERROR, e.getMessage());
        }
    }

    @Override
    public void deleteBindByMerchandiseId(Long merchandiseId) throws BusinessException {
        try {
            int i = this.baseMapper.removeByMerchandiseId(merchandiseId);
            if (i > 0) {
                log.info("成功清除商品和服务类型的绑定关系");
            }
        } catch (Exception e) {
            throw new BusinessException(ApiCodeEnum.SYSTEM_ERROR, e.getMessage());
        }
    }
}

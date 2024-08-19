package com.group.consult.commerce.persist.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.group.consult.commerce.dao.entity.MerchandiseService;
import com.group.consult.commerce.dao.entity.ServiceType;
import com.group.consult.commerce.dao.mapper.MerchandiseServiceMapper;
import com.group.consult.commerce.exception.BusinessException;
import com.group.consult.commerce.model.ApiCodeEnum;
import com.group.consult.commerce.persist.IMerchandiseServiceService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Override
    public List<MerchandiseService> getServiceTypeListByMerchandiseId(Long merchandiseId) throws BusinessException {
        try {
            LambdaQueryWrapper<MerchandiseService> wrapper = new LambdaQueryWrapper<MerchandiseService>()
                    .eq(MerchandiseService::getMerchandiseId, merchandiseId)
                    .eq(MerchandiseService::getIsDel, 0);
            return this.list(wrapper);
        } catch (Exception e) {
            throw new BusinessException(ApiCodeEnum.SYSTEM_ERROR, e.getMessage());
        }
    }

    @Override
    public List<Long> getServiceTypeIdListByMerchandiseId(Long merchandiseId) throws BusinessException {
        List<MerchandiseService> entityList = this.getServiceTypeListByMerchandiseId(merchandiseId);
        return entityList.stream()
                .map(MerchandiseService::getId)
                .toList();
    }
}

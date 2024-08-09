package com.group.consult.commerce.service.impl;

import com.group.consult.commerce.dao.entity.Merchandise;
import com.group.consult.commerce.exception.BusinessException;
import com.group.consult.commerce.model.ApiCodeEnum;
import com.group.consult.commerce.model.PageResult;
import com.group.consult.commerce.model.dto.MerchandisePageableDTO;
import com.group.consult.commerce.model.vo.MerchandiseVO;
import com.group.consult.commerce.persist.IMerchandiseService;
import com.group.consult.commerce.service.IMerchandiseDomainService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MerchandiseDomainServiceImpl implements IMerchandiseDomainService {

    @Autowired
    private IMerchandiseService merchandiseService;

    @Override
    public boolean deleteMerchandiseById(long merchandiseId) throws BusinessException {
        try {
            return merchandiseService.removeById(merchandiseId);
        } catch (Exception e) {
            throw new BusinessException(ApiCodeEnum.SYSTEM_ERROR, e.getMessage());
        }
    }

    @Override
    public boolean ableMerchandiseById(long merchandiseId) throws BusinessException {
        Merchandise entity = merchandiseService.getMerchandiseById(merchandiseId);
        if(null == entity) {
            throw new BusinessException(ApiCodeEnum.MERCHANDISE_QUERY_NOT_NULL);
        }
        try {
            String status = entity.getStatus();
            if("10".equals(status)) {
                entity.setStatus("20");
            } else {
                entity.setStatus("10");
            }
            return merchandiseService.updateMerchandise(entity);
        } catch (Exception e) {
            throw new BusinessException(ApiCodeEnum.SYSTEM_ERROR, e.getMessage());
        }
    }

    @Override
    public PageResult<MerchandiseVO> obtainMerchandiseList(MerchandisePageableDTO pageableDTO) throws BusinessException {
        return merchandiseService.getMerchandiseList(pageableDTO);
    }
}
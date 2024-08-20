package com.group.consult.commerce.service.impl;

import com.google.common.collect.Lists;
import com.group.consult.commerce.dao.entity.Merchandise;
import com.group.consult.commerce.dao.entity.MerchandiseService;
import com.group.consult.commerce.dao.entity.ServiceType;
import com.group.consult.commerce.exception.BusinessException;
import com.group.consult.commerce.model.ApiCodeEnum;
import com.group.consult.commerce.model.PageResult;
import com.group.consult.commerce.model.dto.*;
import com.group.consult.commerce.model.vo.MerchandiseVO;
import com.group.consult.commerce.model.vo.ServiceTypeVO;
import com.group.consult.commerce.persist.IMerchandiseService;
import com.group.consult.commerce.persist.IMerchandiseServiceService;
import com.group.consult.commerce.persist.IServiceTypeService;
import com.group.consult.commerce.service.IMerchandiseDomainService;
import com.group.consult.commerce.utils.BeanCopyUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MerchandiseDomainServiceImpl implements IMerchandiseDomainService {

    @Autowired
    private IMerchandiseService merchandiseService;

    @Autowired
    private IServiceTypeService serviceTypeService;

    @Autowired
    private IMerchandiseServiceService merchandiseServiceService;

    @Override
    public boolean addMerchandiseInfo(MerchandiseAdditionDTO merchandiseAdditionDTO) throws BusinessException {
        Merchandise entity = BeanCopyUtils.copy(merchandiseAdditionDTO, Merchandise.class);
        // todo
        entity.setMerchandiseCode("sdfsgsdf");
        return merchandiseService.insertMerchandise(entity);
    }

    @Override
    public boolean editMerchandiseById(MerchandiseEditionDTO merchandiseEditionDTO) throws BusinessException {
        Long merchandiseId = merchandiseEditionDTO.getMerchandiseId();
        Merchandise entity = merchandiseService.getMerchandiseByIdNotNull(merchandiseId);
        entity.setMerchandiseName(merchandiseEditionDTO.getMerchandiseName());
        entity.setBusinessPrice(merchandiseEditionDTO.getBusinessPrice());
        entity.setBusinessEnable(merchandiseEditionDTO.getBusinessEnable());
        entity.setCustomerPrice(merchandiseEditionDTO.getCustomerPrice());
        entity.setCustomerEnable(merchandiseEditionDTO.getCustomerEnable());
        return merchandiseService.updateMerchandise(entity);
    }

    @Override
    public boolean deleteMerchandiseById(long merchandiseId) throws BusinessException {
        merchandiseService.getMerchandiseByIdNotNull(merchandiseId);
        try {
            return merchandiseService.removeById(merchandiseId);
        } catch (Exception e) {
            throw new BusinessException(ApiCodeEnum.SYSTEM_ERROR, e.getMessage());
        }
    }

    @Override
    public boolean ableMerchandiseById(long merchandiseId) throws BusinessException {
        Merchandise entity = merchandiseService.getMerchandiseByIdNotNull(merchandiseId);
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

    @Override
    public MerchandiseVO obtainMerchandise(long merchandiseId) throws BusinessException {
        Merchandise entity = merchandiseService.getMerchandiseById(merchandiseId);
        List<Long> serviceTypeIdList = merchandiseServiceService.getServiceTypeIdListByMerchandiseId(merchandiseId);
        List<ServiceTypeVO> serviceTypeList = serviceTypeService.getServiceTypeListByIdList(serviceTypeIdList);
        MerchandiseVO merchandiseVO = BeanCopyUtils.copy(entity, MerchandiseVO.class);
        if(null != merchandiseVO) {
            merchandiseVO.setServiceTypeVOList(serviceTypeList);
        }
        return merchandiseVO;
    }

    @Override
    public boolean addServiceType(ServiceTypeAdditionDTO serviceTypeAdditionDTO) throws BusinessException {
        ServiceType entity = BeanCopyUtils.copy(serviceTypeAdditionDTO, ServiceType.class);
        return serviceTypeService.insertServiceType(entity);
    }

    @Override
    public boolean editServiceTypeById(ServiceTypeEditionDTO serviceTypeEditionDTO) throws BusinessException {
        Long serviceTypeId = serviceTypeEditionDTO.getServiceTypeId();
        ServiceType entity = serviceTypeService.getServiceTypeByIdNotNull(serviceTypeId);
        entity.setServiceTypeName(serviceTypeEditionDTO.getServiceTypeName());
        entity.setServiceTypeStatus(serviceTypeEditionDTO.getServiceTypeStatus());
        return serviceTypeService.updateServiceType(entity);
    }

    @Override
    public PageResult<ServiceTypeVO> obtainPageableServiceTypeList(ServiceTypePageableDTO pageableDTO) throws BusinessException {
        return serviceTypeService.getPageableServiceTypeList(pageableDTO);
    }

    @Override
    public List<ServiceTypeVO> obtainAllServiceTypeList(ServiceTypeSearchDTO serviceTypeSearchDTO) throws BusinessException {
        return serviceTypeService.getAllServiceTypeList(serviceTypeSearchDTO);
    }

    @Override
    public ServiceTypeVO obtainServiceType(long serviceTypeId) throws BusinessException {
        ServiceType entity = serviceTypeService.getServiceTypeById(serviceTypeId);
        return BeanCopyUtils.copy(entity, ServiceTypeVO.class);
    }

    @Override
    public boolean bindMerchandiseService(MerchandiseBindDTO merchandiseBindDTO) throws BusinessException {

        Long merchandiseId = merchandiseBindDTO.getMerchandiseId();
        // 删除当前商品的绑定关系
        merchandiseServiceService.deleteBindByMerchandiseId(merchandiseId);

        // 新增商品的绑定关系
        List<Long> serviceTypeIdList = merchandiseBindDTO.getServiceTypeIdList();
        List<MerchandiseService> merchandiseServicesList = Lists.newArrayList();
        serviceTypeIdList.forEach(serviceTypeId -> {
            MerchandiseService entity = MerchandiseService.builder().merchandiseId(merchandiseId).serviceTypeId(serviceTypeId).build();
            merchandiseServicesList.add(entity);
        });
        return merchandiseServiceService.batchInsertMerchandiseService(merchandiseServicesList);
    }
}
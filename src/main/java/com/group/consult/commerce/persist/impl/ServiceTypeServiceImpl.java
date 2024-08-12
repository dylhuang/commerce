package com.group.consult.commerce.persist.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.group.consult.commerce.dao.entity.Merchandise;
import com.group.consult.commerce.dao.entity.ServiceType;
import com.group.consult.commerce.dao.mapper.ServiceTypeMapper;
import com.group.consult.commerce.exception.BusinessException;
import com.group.consult.commerce.model.ApiCodeEnum;
import com.group.consult.commerce.model.PageResult;
import com.group.consult.commerce.model.dto.ServiceTypePageableDTO;
import com.group.consult.commerce.model.dto.ServiceTypeSearchDTO;
import com.group.consult.commerce.model.vo.MerchandiseVO;
import com.group.consult.commerce.model.vo.ServiceTypeVO;
import com.group.consult.commerce.persist.IServiceTypeService;
import com.group.consult.commerce.utils.SqlUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 服务类型表 服务实现类
 *
 * @author Huang, Dylan Bo
 * @since 2024/08/07
 */
@Service
public class ServiceTypeServiceImpl extends ServiceImpl<ServiceTypeMapper, ServiceType> implements IServiceTypeService {

    @Override
    public boolean insertServiceType(ServiceType serviceType) throws BusinessException {
        try {
            return this.saveOrUpdate(serviceType);
        } catch (Exception e) {
            throw new BusinessException(ApiCodeEnum.SYSTEM_ERROR, e.getMessage());
        }
    }

    @Override
    public boolean updateServiceType(ServiceType serviceType) throws BusinessException {
        try {
            return this.updateById(serviceType);
        } catch (Exception e) {
            throw new BusinessException(ApiCodeEnum.SYSTEM_ERROR, e.getMessage());
        }
    }

    @Override
    public ServiceType getServiceTypeById(long serviceTypeId) throws BusinessException {
        try {
            return this.getById(serviceTypeId);
        } catch (Exception e) {
            throw new BusinessException(ApiCodeEnum.SYSTEM_ERROR, e.getMessage());
        }
    }

    @Override
    public ServiceType getServiceTypeByIdNotNull(long serviceTypeId) throws BusinessException {
        ServiceType entity = this.getServiceTypeById(serviceTypeId);
        if(null == entity) {
            throw new BusinessException(ApiCodeEnum.MERCHANDISE_QUERY_NOT_NULL);
        }
        return entity;
    }

    @Override
    public PageResult<ServiceTypeVO> getPageableServiceTypeList(ServiceTypePageableDTO pageableDTO) throws BusinessException {
        try {
            pageableDTO.initWithUpdateTimeSort();
            LambdaQueryWrapper<ServiceType> wrapper = Wrappers.lambdaQuery();
            Optional.ofNullable(pageableDTO.getServiceTypeName())
                    .filter(StringUtils::isNotEmpty)
                    .ifPresent(o -> wrapper.like(ServiceType::getServiceTypeName, o));
            Optional.ofNullable(pageableDTO.getServiceTypeStatus())
                    .filter(StringUtils::isNotEmpty)
                    .ifPresent(o -> wrapper.eq(ServiceType::getServiceTypeStatus, o));
            SqlUtils.commonOrderBy(pageableDTO.getSorts(), wrapper);
            Page<ServiceType> page = this.page(Page.of(pageableDTO.getPageNum(), pageableDTO.getPageSize()), wrapper);
            List<ServiceTypeVO> resultList = page.getRecords().stream().map(ServiceTypeVO::of).collect(Collectors.toList());
            return PageResult.of(resultList, page);
        } catch (Exception e) {
            throw new BusinessException(ApiCodeEnum.SYSTEM_ERROR, e.getMessage());
        }
    }

    @Override
    public List<ServiceTypeVO> getAllServiceTypeList(ServiceTypeSearchDTO serviceTypeSearchDTO) throws BusinessException {
        LambdaQueryWrapper<ServiceType> wrapper = Wrappers.lambdaQuery();
        Optional.ofNullable(serviceTypeSearchDTO.getServiceTypeName())
                .filter(StringUtils::isNotEmpty)
                .ifPresent(o -> wrapper.like(ServiceType::getServiceTypeName, o));
        Optional.ofNullable(serviceTypeSearchDTO.getServiceTypeStatus())
                .filter(StringUtils::isNotEmpty)
                .ifPresent(o -> wrapper.eq(ServiceType::getServiceTypeStatus, o));
        List<ServiceType> entityList = this.list(wrapper);
        return entityList.stream().map(ServiceTypeVO::of).toList();
    }
}

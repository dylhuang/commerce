package com.group.consult.commerce.persist;

import com.baomidou.mybatisplus.extension.service.IService;
import com.group.consult.commerce.dao.entity.Merchandise;
import com.group.consult.commerce.dao.entity.ServiceType;
import com.group.consult.commerce.exception.BusinessException;
import com.group.consult.commerce.model.PageResult;
import com.group.consult.commerce.model.dto.MerchandisePageableDTO;
import com.group.consult.commerce.model.dto.ServiceTypePageableDTO;
import com.group.consult.commerce.model.dto.ServiceTypeSearchDTO;
import com.group.consult.commerce.model.vo.MerchandiseVO;
import com.group.consult.commerce.model.vo.ServiceTypeVO;

import java.util.List;

/**
 * 服务类型表 服务类
 *
 * @author Huang, Dylan Bo
 * @since 2024/08/07
 */
public interface IServiceTypeService extends IService<ServiceType> {

    /**
     * 新增商品服务类型
     *
     * @param serviceType ServiceType
     * @return boolean
     * @throws BusinessException BusinessException
     */
    boolean insertServiceType(ServiceType serviceType) throws BusinessException;

    /**
     * 修改商品服务类型
     *
     * @param serviceType ServiceType
     * @return boolean
     * @throws BusinessException BusinessException
     */
    boolean updateServiceType(ServiceType serviceType) throws BusinessException;

    /**
     * 根据服务类型ID获取服务类型
     *
     * @param serviceTypeId long
     * @return boolean
     * @throws BusinessException BusinessException
     */
    ServiceType getServiceTypeById(long serviceTypeId) throws BusinessException;

    /**
     * 根据服务类型ID获取服务类型【一定包含有服务类型】
     *
     * @param serviceTypeId long
     * @return boolean
     * @throws BusinessException BusinessException
     */
    ServiceType getServiceTypeByIdNotNull(long serviceTypeId) throws BusinessException;

    /**
     * 获取服务类型列表分页信息
     *
     * @param pageableDTO ServiceTypePageableDTO
     * @return PageResult<ServiceTypeVO>
     * @throws BusinessException BusinessException
     */
    PageResult<ServiceTypeVO> getPageableServiceTypeList(ServiceTypePageableDTO pageableDTO) throws BusinessException;

    /**
     * 获取服务类型列表信息
     *
     * @param serviceTypeSearchDTO ServiceTypeSearchDTO
     * @return List<ServiceTypeVO>
     * @throws BusinessException BusinessException
     */
    List<ServiceTypeVO> getAllServiceTypeList(ServiceTypeSearchDTO serviceTypeSearchDTO) throws BusinessException;

    /**
     * 根据service type id list 获取serviceType列表
     *
     * @param serviceTypeIdList serviceTypeIdList
     * @return List<ServiceTypeVO>
     * @throws BusinessException BusinessException
     */
    List<ServiceTypeVO> getServiceTypeListByIdList(List<Long> serviceTypeIdList) throws BusinessException;
}

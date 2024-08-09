package com.group.consult.commerce.service;

import com.group.consult.commerce.exception.BusinessException;
import com.group.consult.commerce.model.PageResult;
import com.group.consult.commerce.model.dto.MerchandiseAdditionDTO;
import com.group.consult.commerce.model.dto.MerchandiseEditionDTO;
import com.group.consult.commerce.model.dto.MerchandisePageableDTO;
import com.group.consult.commerce.model.vo.MerchandiseVO;

/**
 * 商品领域模型相关接口
 *
 * @author huangbo
 * @since 2024/08/08
 */
public interface IMerchandiseDomainService {

    /**
     * 新增商品信息
     *
     * @param merchandiseAdditionDTO MerchandiseAdditionDTO
     * @return boolean
     * @throws BusinessException BusinessException
     */
    boolean addMerchandiseInfo(MerchandiseAdditionDTO merchandiseAdditionDTO) throws BusinessException;

    /**
     * 根据商品ID修改商品信息
     *
     * @param merchandiseEditionDTO MerchandiseEditionDTO
     * @return boolean
     * @throws BusinessException BusinessException
     */
    boolean editMerchandiseById(MerchandiseEditionDTO merchandiseEditionDTO) throws BusinessException;

    /**
     * 根据商品ID删除商品
     *
     * @param merchandiseId merchandiseId
     * @return boolean
     * @throws BusinessException BusinessException
     */
    boolean deleteMerchandiseById(long merchandiseId) throws BusinessException;

    /**
     * 根据商品ID更改商品状态
     *
     * @param merchandiseId merchandiseId
     * @return boolean
     * @throws BusinessException BusinessException
     */
    boolean ableMerchandiseById(long merchandiseId) throws BusinessException;

    /**
     * 获取商品(分页)列表
     *
     * @param pageableDTO MerchandisePageableDTO
     * @return PageResult<MerchandiseVO>
     * @throws BusinessException BusinessException
     * @author Huang, Dylan Bo
     */
    PageResult<MerchandiseVO> obtainMerchandiseList(MerchandisePageableDTO pageableDTO) throws BusinessException;

    /**
     * 根据商品ID获取商品信息详情
     *
     * @param merchandiseId long
     * @return MerchandiseVO
     * @throws BusinessException BusinessException
     */
    MerchandiseVO obtainMerchandise(long merchandiseId) throws BusinessException;
}

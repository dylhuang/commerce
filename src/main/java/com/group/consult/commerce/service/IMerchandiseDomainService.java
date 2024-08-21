package com.group.consult.commerce.service;

import com.group.consult.commerce.exception.BusinessException;
import com.group.consult.commerce.model.PageResult;
import com.group.consult.commerce.model.dto.*;
import com.group.consult.commerce.model.vo.MerchandiseVO;
import com.group.consult.commerce.model.vo.ProductVO;
import com.group.consult.commerce.model.vo.ServiceTypeVO;

import java.util.List;

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


    // =============================================================


    /**
     * 新增产品信息
     *
     * @param productAdditionDTO ProductAdditionDTO
     * @return boolean
     * @throws BusinessException BusinessException
     */
    boolean addProductInfo(ProductAdditionDTO productAdditionDTO) throws BusinessException;

    /**
     * 根据产品ID修改产品信息
     *
     * @param productEditionDTO ProductEditionDTO
     * @return boolean
     * @throws BusinessException BusinessException
     */
    boolean editProductById(ProductEditionDTO productEditionDTO) throws BusinessException;

    /**
     * 根据产品ID删除产品
     *
     * @param productId productId
     * @return boolean
     * @throws BusinessException BusinessException
     */
    boolean deleteProductById(long productId) throws BusinessException;

    /**
     * 根据产品ID更改产品状态
     *
     * @param productId productId
     * @return boolean
     * @throws BusinessException BusinessException
     */
    boolean ableProductById(long productId) throws BusinessException;

    /**
     * 获取产品(分页)列表
     *
     * @param pageableDTO ProductPageableDTO
     * @return PageResult<ProductVO>
     * @throws BusinessException BusinessException
     * @author Huang, Dylan Bo
     */
    PageResult<ProductVO> obtainProductList(ProductPageableDTO pageableDTO) throws BusinessException;

    /**
     * 根据商品ID获取商品信息详情
     *
     * @param productId productId
     * @return ProductVO
     * @throws BusinessException BusinessException
     */
    ProductVO obtainProductVO(long productId) throws BusinessException;


    // =============================================================







    /**
     * 新增服务类型
     *
     * @param serviceTypeAdditionDTO ServiceTypeAdditionDTO
     * @return boolean
     * @throws BusinessException BusinessException
     */
    boolean addServiceType(ServiceTypeAdditionDTO serviceTypeAdditionDTO) throws BusinessException;

    /**
     * 根据服务类型ID修改服务类型
     *
     * @param serviceTypeEditionDTO ServiceTypeEditionDTO
     * @return boolean
     * @throws BusinessException BusinessException
     */
    boolean editServiceTypeById(ServiceTypeEditionDTO serviceTypeEditionDTO) throws BusinessException;

    /**
     * 获取服务类型(分页)列表
     *
     * @param pageableDTO ServiceTypePageableDTO
     * @return PageResult<ServiceTypeVO>
     * @throws BusinessException BusinessException
     * @author Huang, Dylan Bo
     */
    PageResult<ServiceTypeVO> obtainPageableServiceTypeList(ServiceTypePageableDTO pageableDTO) throws BusinessException;

    /**
     * 获取所有服务类型列表
     *
     * @param serviceTypeSearchDTO ServiceTypeSearchDTO
     * @return List<ServiceTypeVO>
     * @throws BusinessException BusinessException
     */
    List<ServiceTypeVO> obtainAllServiceTypeList(ServiceTypeSearchDTO serviceTypeSearchDTO) throws BusinessException;

    /**
     * 根据服务类型ID获取服务类型详情
     *
     * @param serviceTypeId long
     * @return MerchandiseVO
     * @throws BusinessException BusinessException
     */
    ServiceTypeVO obtainServiceType(long serviceTypeId) throws BusinessException;

    /**
     * 绑定产品和服务类型
     *
     * @param productBindDTO MerchandiseBindDTO
     * @return boolean
     * @throws BusinessException BusinessException
     */
    boolean bindProductService(ProductBindDTO productBindDTO) throws BusinessException;

}

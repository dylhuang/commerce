package com.group.consult.commerce.service.impl;

import com.google.common.collect.Lists;
import com.group.consult.commerce.dao.entity.*;
import com.group.consult.commerce.exception.BusinessException;
import com.group.consult.commerce.model.ApiCodeEnum;
import com.group.consult.commerce.model.PageResult;
import com.group.consult.commerce.model.dto.*;
import com.group.consult.commerce.model.vo.MerchandiseVO;
import com.group.consult.commerce.model.vo.ProductVO;
import com.group.consult.commerce.model.vo.ServiceTypeVO;
import com.group.consult.commerce.persist.*;
import com.group.consult.commerce.service.IMerchandiseDomainService;
import com.group.consult.commerce.utils.BeanCopyUtils;
import com.group.consult.commerce.utils.GerneralUtil;
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
    private IMerchandiseProductService merchandiseProductService;

    @Autowired
    private IProductService productService;

    @Autowired
    private IServiceTypeService serviceTypeService;

    @Autowired
    private IProductServiceService merchandiseServiceService;

    @Override
    public boolean addMerchandiseInfo(MerchandiseAdditionDTO merchandiseAdditionDTO) throws BusinessException {
        Merchandise entity = BeanCopyUtils.copy(merchandiseAdditionDTO, Merchandise.class);
        assert entity != null;
        entity.setMerchandiseCode(GerneralUtil.randomCharacter());
        boolean merchandiseFlag = merchandiseService.insertMerchandise(entity);
        List<MerchandiseProductAdditionDTO> relationList = merchandiseAdditionDTO.getRelationList();
        List<MerchandiseProduct> merchandiseProductList = BeanCopyUtils.copyBeanList(relationList, MerchandiseProduct.class);
        merchandiseProductList.forEach(temp -> {
            temp.setMerchandiseId(entity.getId());
        });
        boolean mpFlag = merchandiseProductService.batchInsertMerchandiseProduct(merchandiseProductList);
        return merchandiseFlag && mpFlag;
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
            if ("10".equals(status)) {
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
        List<Long> serviceTypeIdList = merchandiseServiceService.getServiceTypeIdListByProductId(merchandiseId);
        List<ServiceTypeVO> serviceTypeList = serviceTypeService.getServiceTypeListByIdList(serviceTypeIdList);
        MerchandiseVO merchandiseVO = BeanCopyUtils.copy(entity, MerchandiseVO.class);
        if (null != merchandiseVO) {
            merchandiseVO.setServiceTypeVOList(serviceTypeList);
        }
        return merchandiseVO;
    }

    @Override
    public boolean addProductInfo(ProductAdditionDTO productAdditionDTO) throws BusinessException {
        Product entity = BeanCopyUtils.copy(productAdditionDTO, Product.class);
        // todo
        entity.setCode("sdfsgsdf");
        return productService.insertProduct(entity);
    }

    @Override
    public boolean editProductById(ProductEditionDTO productEditionDTO) throws BusinessException {
        Long productId = productEditionDTO.getProductId();
        Product entity = productService.getProductByIdNotNull(productId);
        entity.setName(productEditionDTO.getMerchandiseName());
        entity.setPrice(productEditionDTO.getPrice());
        return productService.updateProduct(entity);
    }

    @Override
    public boolean deleteProductById(long productId) throws BusinessException {
        productService.getProductByIdNotNull(productId);
        try {
            return productService.removeById(productId);
        } catch (Exception e) {
            throw new BusinessException(ApiCodeEnum.SYSTEM_ERROR, e.getMessage());
        }
    }

    @Override
    public boolean ableProductById(long productId) throws BusinessException {
        Product entity = productService.getProductByIdNotNull(productId);
        try {
            String status = entity.getStatus();
            if ("10".equals(status)) {
                entity.setStatus("20");
            } else {
                entity.setStatus("10");
            }
            return productService.updateProduct(entity);
        } catch (Exception e) {
            throw new BusinessException(ApiCodeEnum.SYSTEM_ERROR, e.getMessage());
        }
    }

    @Override
    public PageResult<ProductVO> obtainProductList(ProductPageableDTO pageableDTO) throws BusinessException {
        return productService.getProductList(pageableDTO);
    }

    @Override
    public ProductVO obtainProductVO(long productId) throws BusinessException {
        Product entity = productService.getProductById(productId);
        List<Long> serviceTypeIdList = merchandiseServiceService.getServiceTypeIdListByProductId(productId);
        List<ServiceTypeVO> serviceTypeList = serviceTypeService.getServiceTypeListByIdList(serviceTypeIdList);
        ProductVO productVO = BeanCopyUtils.copy(entity, ProductVO.class);
        if (null != productVO) {
            productVO.setServiceTypeVOList(serviceTypeList);
        }
        return productVO;
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
    public boolean bindProductService(ProductBindDTO productBindDTO) throws BusinessException {
        Long productId = productBindDTO.getProductId();
        // 删除当前产品的绑定关系
        merchandiseServiceService.deleteBindByProductId(productId);c
        // 新增产品的绑定关系
        List<Long> serviceTypeIdList = productBindDTO.getServiceTypeIdList();
        List<ProductService> productServicesList = Lists.newArrayList();
        serviceTypeIdList.forEach(serviceTypeId -> {
            ProductService entity = ProductService.builder().productId(productId).serviceTypeId(serviceTypeId).build();
            productServicesList.add(entity);
        });
        return merchandiseServiceService.batchInsertProductService(productServicesList);
    }
}
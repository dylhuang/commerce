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
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

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
    private IProductServiceService productServiceService;

    @Autowired
    private IServiceTypeService serviceTypeService;

    @Override
    public boolean addMerchandiseInfo(MerchandiseAdditionDTO merchandiseAdditionDTO) throws BusinessException {
        Merchandise entity = BeanCopyUtils.copy(merchandiseAdditionDTO, Merchandise.class);
        assert entity != null;
        entity.setMerchandiseCode(GerneralUtil.randomCharacter());
        boolean merchandiseFlag = merchandiseService.insertMerchandise(entity);
        List<MerchandiseProductRelationDTO> relationList = merchandiseAdditionDTO.getRelationList();
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
        boolean merchandiseFlag = merchandiseService.updateMerchandise(entity);
        merchandiseProductService.deleteRelationByMerchandiseId(merchandiseId);
        List<MerchandiseProductRelationDTO> relationList = merchandiseEditionDTO.getRelationList();
        List<MerchandiseProduct> merchandiseProductList = BeanCopyUtils.copyBeanList(relationList, MerchandiseProduct.class);
        merchandiseProductList.forEach(temp -> {
            temp.setMerchandiseId(entity.getId());
        });
        boolean mpFlag = merchandiseProductService.batchInsertMerchandiseProduct(merchandiseProductList);
        return merchandiseFlag && mpFlag;
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
        PageResult<MerchandiseVO> pageResult = merchandiseService.getMerchandiseList(pageableDTO);
        List<MerchandiseVO> merchandiseList = pageResult.getList();
        merchandiseList.forEach(merchandise -> {
            Long merchandiseId = merchandise.getId();
            List<MerchandiseProduct> merchandiseProductList = merchandiseProductService.getMerchandiseProductListByMerchandiseId(merchandiseId);

            List<Long> productIdList = merchandiseProductList.stream()
                    .map(MerchandiseProduct::getProductId)
                    .toList();

            Map<Long, MerchandiseProduct> productMap = merchandiseProductList.stream()
                    .collect(Collectors.toMap(MerchandiseProduct::getProductId, product -> product));

//            List<Long> productIdList = merchandiseProductService.getProductIdListByMerchandiseId(merchandiseId);

            if (!CollectionUtils.isEmpty(productIdList)) {
                List<ProductVO> productList = productService.getProductListByIdList(productIdList);
                productList.forEach(product -> {
                    product.setProductNumber(productMap.get(product.getId()).getProductNumber());
                });
                merchandise.setProductVOList(productList);
            }
        });
        pageResult.setList(merchandiseList);
        return pageResult;
    }

    @Override
    public MerchandiseVO obtainMerchandise(long merchandiseId) throws BusinessException {
        Merchandise entity = merchandiseService.getMerchandiseById(merchandiseId);

        List<MerchandiseProduct> merchandiseProductList = merchandiseProductService.getMerchandiseProductListByMerchandiseId(merchandiseId);

        List<Long> merchandiseProductIdList = merchandiseProductList.stream()
                .map(MerchandiseProduct::getProductId)
                .toList();

        Map<Long, MerchandiseProduct> productMap = merchandiseProductList.stream()
                .collect(Collectors.toMap(MerchandiseProduct::getProductId, product -> product));

//        List<Long> merchandiseProductIdList = merchandiseProductService.getProductIdListByMerchandiseId(merchandiseId);
        List<ProductVO> productList = productService.getProductListByIdList(merchandiseProductIdList);
        productList.forEach(product -> {
            product.setProductNumber(productMap.get(product.getId()).getProductNumber());
        });

        MerchandiseVO merchandiseVO = BeanCopyUtils.copy(entity, MerchandiseVO.class);
        if (null != merchandiseVO) {
            merchandiseVO.setProductVOList(productList);
        }
        return merchandiseVO;
    }

    @Override
    public boolean addProductInfo(ProductAdditionDTO productAdditionDTO) throws BusinessException {
        Product entity = BeanCopyUtils.copy(productAdditionDTO, Product.class);
        assert entity != null;
        entity.setCode(GerneralUtil.randomCharacter());
        boolean productFlag = productService.insertProduct(entity);
        List<Long> relationList = productAdditionDTO.getServiceTypeIdList();
        List<ProductService> productServiceList = Lists.newArrayList();
        relationList.forEach(temp -> {
            productServiceList.add(ProductService.builder().productId(entity.getId()).serviceTypeId(temp).build());
        });
        boolean psFlag = productServiceService.batchInsertProductService(productServiceList);
        return productFlag && psFlag;
    }

    @Override
    public boolean editProductById(ProductEditionDTO productEditionDTO) throws BusinessException {
        Long productId = productEditionDTO.getProductId();
        Product entity = productService.getProductByIdNotNull(productId);
        entity.setName(productEditionDTO.getName());
        entity.setPrice(productEditionDTO.getPrice());
        boolean productFlag = productService.updateProduct(entity);
        productServiceService.deleteRelationByProductId(productId);
        List<Long> relationList = productEditionDTO.getServiceTypeIdList();
        List<ProductService> productServiceList = Lists.newArrayList();
        relationList.forEach(temp -> {
            productServiceList.add(ProductService.builder().productId(productId).serviceTypeId(temp).build());
        });
        boolean psFlag = productServiceService.batchInsertProductService(productServiceList);
        return productFlag && psFlag;
    }

    @Override
    public boolean deleteProductById(long productId) throws BusinessException {
        boolean existRelation = merchandiseProductService.existRelationByProductId(productId);
        if(existRelation) {
            throw new BusinessException(ApiCodeEnum.PRODUCT_EXIST_RELATION_MERCHANDISE);
        }
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
        PageResult<ProductVO> pageResult = productService.getProductList(pageableDTO);
        List<ProductVO> productList = pageResult.getList();
        productList.forEach(product -> {
            Long productId = product.getId();
            List<Long> serviceTypeIdList = productServiceService.getServiceTypeIdListByProductId(productId);
            if (!CollectionUtils.isEmpty(serviceTypeIdList)) {
                List<ServiceTypeVO> serviceTypeList = serviceTypeService.getServiceTypeListByIdList(serviceTypeIdList);
                product.setServiceTypeVOList(serviceTypeList);
            }
        });
        pageResult.setList(productList);
        return pageResult;
    }

    @Override
    public ProductVO obtainProductVO(long productId) throws BusinessException {
        ProductVO productVO = null;
        Product entity = productService.getProductById(productId);
        List<Long> serviceTypeIdList = productServiceService.getServiceTypeIdListByProductId(productId);
        if (!CollectionUtils.isEmpty(serviceTypeIdList)) {
            List<ServiceTypeVO> serviceTypeList = serviceTypeService.getServiceTypeListByIdList(serviceTypeIdList);
            productVO = BeanCopyUtils.copy(entity, ProductVO.class);
            if (null != productVO) {
                productVO.setServiceTypeVOList(serviceTypeList);
            }
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
    public boolean deleteServiceTypeById(long serviceTypeId) throws BusinessException {
        boolean existRelation = productServiceService.existRelationByServiceTypeId(serviceTypeId);
        if(existRelation) {
            throw new BusinessException(ApiCodeEnum.SERVICE_TYPE_EXIST_RELATION_PRODUCT);
        }
        serviceTypeService.getServiceTypeByIdNotNull(serviceTypeId);
        try {
            return productService.removeById(serviceTypeId);
        } catch (Exception e) {
            throw new BusinessException(ApiCodeEnum.SYSTEM_ERROR, e.getMessage());
        }
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

}
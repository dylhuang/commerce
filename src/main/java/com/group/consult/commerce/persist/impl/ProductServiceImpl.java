package com.group.consult.commerce.persist.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.group.consult.commerce.dao.entity.Product;
import com.group.consult.commerce.dao.entity.ServiceType;
import com.group.consult.commerce.dao.mapper.ProductMapper;
import com.group.consult.commerce.exception.BusinessException;
import com.group.consult.commerce.model.ApiCodeEnum;
import com.group.consult.commerce.model.PageResult;
import com.group.consult.commerce.model.dto.ProductPageableDTO;
import com.group.consult.commerce.model.vo.ProductVO;
import com.group.consult.commerce.model.vo.ServiceTypeVO;
import com.group.consult.commerce.persist.IProductService;
import com.group.consult.commerce.utils.BeanCopyUtils;
import com.group.consult.commerce.utils.SqlUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 产品表 服务实现类
 *
 * @author Huang, Dylan Bo
 * @since 2024/08/20
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {

    @Override
    public Product getProductById(long productId) throws BusinessException {
        try {
            return this.getById(productId);
        } catch (Exception e) {
            throw new BusinessException(ApiCodeEnum.SYSTEM_ERROR, e.getMessage());
        }
    }

    @Override
    public Product getProductByIdNotNull(long productId) throws BusinessException {
        Product entity = this.getProductById(productId);
        if (null == entity) {
            throw new BusinessException(ApiCodeEnum.MERCHANDISE_QUERY_NOT_NULL);
        }
        return entity;
    }

    @Override
    public boolean insertProduct(Product product) throws BusinessException {
        try {
            return this.saveOrUpdate(product);
        } catch (Exception e) {
            throw new BusinessException(ApiCodeEnum.SYSTEM_ERROR, e.getMessage());
        }
    }

    @Override
    public boolean updateProduct(Product product) throws BusinessException {
        try {
            return this.updateById(product);
        } catch (Exception e) {
            throw new BusinessException(ApiCodeEnum.SYSTEM_ERROR, e.getMessage());
        }
    }

    @Override
    public PageResult<ProductVO> getProductList(ProductPageableDTO pageableDTO) throws BusinessException {
        try {
            pageableDTO.initWithUpdateTimeSort();
            LambdaQueryWrapper<Product> wrapper = Wrappers.lambdaQuery();
            Optional.ofNullable(pageableDTO.getCode())
                    .filter(StringUtils::isNotEmpty)
                    .ifPresent(o -> wrapper.like(Product::getCode, o));
            Optional.ofNullable(pageableDTO.getName())
                    .filter(StringUtils::isNotEmpty)
                    .ifPresent(o -> wrapper.like(Product::getName, o));
            Optional.ofNullable(pageableDTO.getStatus())
                    .filter(StringUtils::isNotEmpty)
                    .ifPresent(o -> wrapper.eq(Product::getStatus, o));
            SqlUtils.commonOrderBy(pageableDTO.getSorts(), wrapper);
            Page<Product> page = this.page(Page.of(pageableDTO.getPageNum(), pageableDTO.getPageSize()), wrapper);
            List<ProductVO> resultList = page.getRecords().stream().map(ProductVO::of).collect(Collectors.toList());
            return PageResult.of(resultList, page);
        } catch (Exception e) {
            throw new BusinessException(ApiCodeEnum.SYSTEM_ERROR, e.getMessage());
        }
    }

    @Override
    public List<ProductVO> getProductListByIdList(List<Long> productIdList) throws BusinessException {
        try {
            List<Product> entityList = this.baseMapper.selectBatchIds(productIdList);
            return BeanCopyUtils.copyBeanList(entityList, ProductVO.class);
        } catch (Exception e) {
            throw new BusinessException(ApiCodeEnum.SYSTEM_ERROR, e.getMessage());
        }
    }

}

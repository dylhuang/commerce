package com.group.consult.commerce.persist;


import com.baomidou.mybatisplus.extension.service.IService;
import com.group.consult.commerce.dao.entity.Merchandise;
import com.group.consult.commerce.dao.entity.Product;
import com.group.consult.commerce.exception.BusinessException;
import com.group.consult.commerce.model.PageResult;
import com.group.consult.commerce.model.dto.MerchandisePageableDTO;
import com.group.consult.commerce.model.dto.ProductPageableDTO;
import com.group.consult.commerce.model.vo.MerchandiseVO;
import com.group.consult.commerce.model.vo.ProductVO;

/**
 * 商品表 服务类
 *
 * @author Huang, Dylan Bo
 * @since 2024/08/20
 */
public interface IProductService extends IService<Product> {

    /**
     * 根据产品ID获取产品信息
     *
     * @param productId long
     * @return boolean
     * @throws BusinessException BusinessException
     */
    Product getProductById(long productId) throws BusinessException;

    /**
     * 根据产品ID获取产品信息【一定包含有产品信息】
     *
     * @param productId long
     * @return boolean
     * @throws BusinessException BusinessException
     */
    Product getProductByIdNotNull(long productId) throws BusinessException;

    /**
     * 新增产品信息
     *
     * @param product Product
     * @return boolean
     * @throws BusinessException BusinessException
     */
    boolean insertProduct(Product product) throws BusinessException;

    /**
     * 修改产品信息
     *
     * @param product Product
     * @return boolean
     * @throws BusinessException BusinessException
     */
    boolean updateProduct(Product product) throws BusinessException;

    /**
     * 获取产品列表分页信息
     *
     * @param pageableDTO ProductPageableDTO
     * @return PageResult<MerchandiseVO>
     * @throws BusinessException BusinessException
     */
    PageResult<ProductVO> getProductList(ProductPageableDTO pageableDTO) throws BusinessException;

}

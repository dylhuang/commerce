package com.group.consult.commerce.controller;

import com.group.consult.commerce.exception.BusinessException;
import com.group.consult.commerce.model.ApiResult;
import com.group.consult.commerce.model.PageResult;
import com.group.consult.commerce.model.dto.ProductAdditionDTO;
import com.group.consult.commerce.model.dto.ProductEditionDTO;
import com.group.consult.commerce.model.dto.ProductPageableDTO;
import com.group.consult.commerce.model.vo.ProductVO;
import com.group.consult.commerce.service.IMerchandiseDomainService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 产品表 前端控制器
 *
 * @author Huang, Dylan Bo
 * @since 2024/08/20
 */
@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@Tag(name = "Product Controller")
@RequestMapping("/api/sys/product")
public class ProductController {

    @Autowired
    IMerchandiseDomainService merchandiseDomainService;

    /**
     * 新增产品信息
     *
     * @param productAdditionDTO ProductAdditionDTO
     * @return Boolean
     */
    @PostMapping("/addProduct")
    @Operation(summary = "新增产品信息", description = "新增产品信息")
    public ApiResult<Boolean> addProduct(@RequestBody ProductAdditionDTO productAdditionDTO) {
        try {
            boolean flag = merchandiseDomainService.addProductInfo(productAdditionDTO);
            return ApiResult.success(flag);
        } catch (BusinessException e) {
            return ApiResult.fail();
        }
    }

    /**
     * 修改产品信息
     *
     * @param productEditionDTO ProductEditionDTO
     * @return Boolean
     */
    @PostMapping("/editProduct")
    @Operation(summary = "修改产品信息", description = "修改产品信息")
    public ApiResult<Boolean> editProduct(@RequestBody ProductEditionDTO productEditionDTO) {
        try {
            boolean flag = merchandiseDomainService.editProductById(productEditionDTO);
            return ApiResult.success(flag);
        } catch (BusinessException e) {
            return ApiResult.fail();
        }
    }

    /**
     * 根据产品ID删除产品
     *
     * @param productId productId
     * @return ApiResult<Boolean>
     */
    @GetMapping("/deleteProduct")
    @Operation(summary = "根据产品ID删除产品", description = "根据产品ID删除产品")
    public ApiResult<Boolean> deleteProduct(long productId) {
        try {
            boolean flag = merchandiseDomainService.deleteProductById(productId);
            return ApiResult.success(flag);
        } catch (BusinessException e) {
            return ApiResult.fail();
        }
    }

    /**
     * 根据产品ID更改产品状态
     *
     * @param productId productId
     * @return ApiResult<Boolean>
     */
    @GetMapping("/ableProduct")
    @Operation(summary = "根据产品ID更改产品状态：使产品可用/不可用", description = "根据产品ID更改产品状态：使产品可用/不可用")
    public ApiResult<Boolean> ableProduct(long productId) {
        try {
            boolean flag = merchandiseDomainService.ableProductById(productId);
            return ApiResult.success(flag);
        } catch (BusinessException e) {
            return ApiResult.fail();
        }
    }

    /**
     * 获取产品（分页）列表
     *
     * @param pageableDTO PageableDTO
     * @return List<ProductVO>
     * @author Huang, Dylan Bo
     */
    @PostMapping("/fetchProductList")
    @Operation(summary = "获取产品（分页）列表", description = "分页查询产品列表")
    public ApiResult<PageResult<ProductVO>> fetchProductList(@RequestBody ProductPageableDTO pageableDTO) {
        try {
            PageResult<ProductVO> result = merchandiseDomainService.obtainProductList(pageableDTO);
            return ApiResult.success(result);
        } catch (BusinessException e) {
            return ApiResult.fail();
        }
    }

    /**
     * 根据产品ID查询产品详情
     *
     * @param productId productId
     * @return ApiResult<ProductVO>
     */
    @GetMapping("/fetchProduct")
    @Operation(summary = "根据产品ID查询产品详情", description = "根据产品ID查询产品详情")
    public ApiResult<ProductVO> fetchProduct(long productId) {
        try {
            ProductVO productVO = merchandiseDomainService.obtainProductVO(productId);
            return ApiResult.success(productVO);
        } catch (BusinessException e) {
            return ApiResult.fail();
        }
    }

}

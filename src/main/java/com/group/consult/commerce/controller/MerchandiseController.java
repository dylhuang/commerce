package com.group.consult.commerce.controller;

import com.group.consult.commerce.exception.BusinessException;
import com.group.consult.commerce.model.ApiResult;
import com.group.consult.commerce.model.PageResult;
import com.group.consult.commerce.model.dto.*;
import com.group.consult.commerce.model.vo.MerchandiseVO;
import com.group.consult.commerce.model.vo.ServiceTypeVO;
import com.group.consult.commerce.service.IMerchandiseDomainService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 商品表 前端控制器
 *
 * @author Huang, Dylan Bo
 * @since 2024/08/07
 */
@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@Tag(name = "Merchandise Controller")
@RequestMapping("/api/sys/merchandise")
public class MerchandiseController {

    @Autowired
    IMerchandiseDomainService merchandiseDomainService;

    /**
     * 新增商品信息
     *
     * @param merchandiseAdditionDTO MerchandiseAdditionDTO
     * @return Boolean
     */
    @PostMapping("/addMerchandise")
    @Operation(summary = "新增商品信息", description = "新增商品信息")
    public ApiResult<Boolean> addMerchandise(@RequestBody MerchandiseAdditionDTO merchandiseAdditionDTO) {
        try {
            boolean flag = merchandiseDomainService.addMerchandiseInfo(merchandiseAdditionDTO);
            return ApiResult.success(flag);
        } catch (BusinessException e) {
            return ApiResult.fail();
        }
    }

    /**
     * 修改商品信息
     *
     * @param merchandiseEditionDTO MerchandiseEditionDTO
     * @return Boolean
     */
    @PostMapping("/editMerchandise")
    @Operation(summary = "修改商品信息", description = "修改商品信息")
    public ApiResult<Boolean> editMerchandise(@RequestBody MerchandiseEditionDTO merchandiseEditionDTO) {
        try {
            boolean flag = merchandiseDomainService.editMerchandiseById(merchandiseEditionDTO);
            return ApiResult.success(flag);
        } catch (BusinessException e) {
            return ApiResult.fail();
        }
    }

    /**
     * 根据商品ID删除商品
     *
     * @param merchandiseId merchandiseId
     * @return ApiResult<Boolean>
     */
    @GetMapping("/deleteMerchandise")
    @Operation(summary = "根据商品ID删除商品", description = "根据商品ID删除商品")
    public ApiResult<Boolean> deleteMerchandise(long merchandiseId) {
        try {
            boolean flag = merchandiseDomainService.deleteMerchandiseById(merchandiseId);
            return ApiResult.success(flag);
        } catch (BusinessException e) {
            return ApiResult.fail();
        }
    }

    /**
     * 根据商品ID更改商品状态
     *
     * @param merchandiseId merchandiseId
     * @return ApiResult<Boolean>
     */
    @GetMapping("/ableMerchandise")
    @Operation(summary = "根据商品ID更改商品状态：使商品可用/不可用", description = "根据商品ID更改商品状态：使商品可用/不可用")
    public ApiResult<Boolean> ableMerchandise(long merchandiseId) {
        try {
            boolean flag = merchandiseDomainService.ableMerchandiseById(merchandiseId);
            return ApiResult.success(flag);
        } catch (BusinessException e) {
            return ApiResult.fail();
        }
    }

    /**
     * 获取商品（分页）列表
     *
     * @param pageableDTO PageableDTO
     * @return List<MerchandiseVO>
     * @author Huang, Dylan Bo
     */
    @PostMapping("/fetchMerchandiseList")
    @Operation(summary = "获取商品（分页）列表", description = "分页查询商品列表")
    public ApiResult<PageResult<MerchandiseVO>> fetchMerchandiseList(@RequestBody MerchandisePageableDTO pageableDTO) {
        try {
            PageResult<MerchandiseVO> result = merchandiseDomainService.obtainMerchandiseList(pageableDTO);
            return ApiResult.success(result);
        } catch (BusinessException e) {
            return ApiResult.fail();
        }
    }

    /**
     * 根据商品ID查询商品详情
     *
     * @param merchandiseId merchandiseId
     * @return ApiResult<Boolean>
     */
    @GetMapping("/fetchMerchandise")
    @Operation(summary = "根据商品ID查询商品详情", description = "根据商品ID查询商品详情")
    public ApiResult<MerchandiseVO> fetchMerchandise(long merchandiseId) {
        try {
            MerchandiseVO merchandiseVO = merchandiseDomainService.obtainMerchandise(merchandiseId);
            return ApiResult.success(merchandiseVO);
        } catch (BusinessException e) {
            return ApiResult.fail();
        }
    }
}

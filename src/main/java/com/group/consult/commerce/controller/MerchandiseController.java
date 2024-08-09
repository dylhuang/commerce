package com.group.consult.commerce.controller;

import com.group.consult.commerce.exception.BusinessException;
import com.group.consult.commerce.model.ApiResult;
import com.group.consult.commerce.model.PageResult;
import com.group.consult.commerce.model.dto.MerchandiseAdditionDTO;
import com.group.consult.commerce.model.dto.MerchandiseEditionDTO;
import com.group.consult.commerce.model.dto.MerchandisePageableDTO;
import com.group.consult.commerce.model.vo.MerchandiseVO;
import com.group.consult.commerce.service.IMerchandiseDomainService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/api/merchandise")
public class MerchandiseController {

    @Autowired
    IMerchandiseDomainService merchandiseDomainService;

    @PostMapping("/addMerchandise")
    @Operation(summary = "add merchandise", description = "ADD MERCHANDISE")
    public ApiResult<Boolean> addMerchandise(@RequestBody MerchandiseAdditionDTO merchandiseAdditionDTO) {
        return ApiResult.success(true);
    }

    @PostMapping("/editMerchandise")
    @Operation(summary = "edit merchandise", description = "EDIT MERCHANDISE")
    public ApiResult<Boolean> editMerchandise(@RequestBody MerchandiseEditionDTO merchandiseEditionDTO) {
        return ApiResult.success(true);
    }

    /**
     * 根据商品ID删除商品
     *
     * @param merchandiseId merchandiseId
     * @return ApiResult<Boolean>
     */
    @GetMapping("/deleteMerchandise")
    @Operation(summary = "delete merchandise", description = "DELETE MERCHANDISE")
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
    @Operation(summary = "enable or unable merchandise", description = "ENABLE OR UNABLE MERCHANDISE")
    public ApiResult<Boolean> ableMerchandise(long merchandiseId) {
        return ApiResult.success(true);
    }

    /**
     * 获取商品列表
     *
     * @param pageableDTO PageableDTO
     * @return List<ApplicationListVO>
     * @author Huang, Dylan Bo
     */
    @PostMapping("/fetchMerchandiseList")
    @Operation(summary = "fetch merchandise list", description = "FETCH MERCHANDISE LIST")
    public ApiResult<PageResult<MerchandiseVO>> fetchMerchandiseList(@RequestBody MerchandisePageableDTO pageableDTO) {
        try {
            PageResult<MerchandiseVO> result = merchandiseDomainService.obtainMerchandiseList(pageableDTO);
            return ApiResult.success(result);
        } catch (BusinessException e) {
            return ApiResult.fail();
        }
    }

}

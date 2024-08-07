package com.group.consult.commerce.controller;

import com.group.consult.commerce.model.ApiResult;
import com.group.consult.commerce.model.dto.MerchandiseAdditionDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/addMerchandise")
    @Operation(summary = "add merchandise", description = "ADD MERCHANDISE")
    public ApiResult<Boolean> addMerchandise(@RequestBody MerchandiseAdditionDTO merchandiseAdditionDTO) {
        return ApiResult.success(true);
    }

}

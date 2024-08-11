package com.group.consult.commerce.controller.sys;

import com.group.consult.commerce.model.ApiResult;
import com.group.consult.commerce.model.dto.MenuAddDTO;
import com.group.consult.commerce.model.dto.MenuEditDTO;
import com.group.consult.commerce.service.ISysMenuDomainService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @title: 菜单管理
 * @description: 菜单管理
 * @author: zl
 * @date: 2024-08-09
 */
@RestController
@RequestMapping("/api/sys/menu")
public class SysMenuController {

    @Autowired
    private ISysMenuDomainService menuDomainService;

    @PostMapping("/add")
    @Operation(summary = "添加菜单")
    public ApiResult<Boolean> addMenu(@RequestBody @Valid MenuAddDTO menuAddDTO) {
        Boolean res =  menuDomainService.addMenu(menuAddDTO);
        return ApiResult.success(res);
    }

    @PutMapping("/edit")
    @Operation(summary = "编辑菜单")
    public ApiResult<Boolean> editMenu(@RequestBody @Valid MenuEditDTO menuEditDTO) {
        Boolean res = menuDomainService.editMenu(menuEditDTO);
        return ApiResult.success(res);
    }

    @DeleteMapping("/remove")
    @Operation(summary = "删除菜单")
    public ApiResult<Boolean> remove(@RequestParam("ids")List<Long> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return ApiResult.success(false);
        }
        return ApiResult.success(menuDomainService.remove(ids));
    }
}

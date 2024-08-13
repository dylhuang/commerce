package com.group.consult.commerce.controller.sys;

import com.group.consult.commerce.model.ApiResult;
import com.group.consult.commerce.model.PageResult;
import com.group.consult.commerce.model.dto.*;
import com.group.consult.commerce.model.vo.SysMenuDetailVO;
import com.group.consult.commerce.model.vo.SysMenuListVO;
import com.group.consult.commerce.model.vo.SysMenuPageListVO;
import com.group.consult.commerce.model.vo.SysMenuTreeListVO;
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

    @GetMapping("/fetchDetail")
    @Operation(summary = "详情")
    public ApiResult<SysMenuDetailVO> fetchDetail(@RequestParam("id") Long id) {
        return ApiResult.success(menuDomainService.fetchDetail(id));
    }

    @PostMapping("/list")
    @Operation(summary = "列表,不分页")
    public ApiResult<List<SysMenuListVO>> list(@RequestBody @Valid SysMenuListDTO menuListDTO) {
        return ApiResult.success(menuDomainService.list(menuListDTO));
    }

    @PostMapping("/pageList")
    @Operation(summary = "列表,分页")
    public ApiResult<PageResult<SysMenuPageListVO>> pageList(@RequestBody @Valid SysMenuPageListDTO menuListDTO) {
        return ApiResult.success(menuDomainService.pageList(menuListDTO));
    }

    @PostMapping("/treeList")
    @Operation(summary = "菜单树")
    public ApiResult<List<SysMenuTreeListVO>> treeList(@RequestBody @Valid SysMenuTreeListDTO dto) {
        return ApiResult.success(menuDomainService.treeList(dto));
    }
}

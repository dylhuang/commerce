package com.group.consult.commerce.controller.sys;

import com.group.consult.commerce.model.ApiResult;
import com.group.consult.commerce.model.PageResult;
import com.group.consult.commerce.model.dto.RoleAddDTO;
import com.group.consult.commerce.model.dto.RoleEditDTO;
import com.group.consult.commerce.model.dto.RolePageListDTO;
import com.group.consult.commerce.model.vo.RoleDetailVO;
import com.group.consult.commerce.model.vo.RoleListVO;
import com.group.consult.commerce.service.ISysRoleDomainService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @title: 角色管理
 * @description: 角色管理
 * @author: zl
 * @date: 2024-08-12
 */
@RestController
@RequestMapping("/api/sys/role")
public class SysRoleController {

    @Autowired
    private ISysRoleDomainService roleDomainService;

    @PostMapping("/add")
    @Operation(summary = "添加")
    public ApiResult<Boolean> add(@RequestBody @Valid RoleAddDTO addDTO) {
        return ApiResult.success(roleDomainService.add(addDTO));
    }

    @PostMapping("/edit")
    @Operation(summary = "编辑")
    public ApiResult<Boolean> edit(@RequestBody @Valid RoleEditDTO editDTO) {
        return ApiResult.success(roleDomainService.edit(editDTO));
    }

    @DeleteMapping("/remove")
    @Operation(summary = "删除")
    public ApiResult<Boolean> remove(@RequestParam("ids")List<Long> ids) {
        return ApiResult.success(roleDomainService.remove(ids));
    }

    @GetMapping("/fetchDetail")
    @Operation(summary = "获取角色详情")
    public ApiResult<RoleDetailVO> fetchDetail(@RequestParam("id") Long id) {
        return ApiResult.success(roleDomainService.fetchDetail(id));
    }

    @PostMapping("/pageList")
    @Operation(summary = "分页列表")
    public ApiResult<PageResult<RoleListVO>> pageList(@RequestBody RolePageListDTO pageListDTO) {
        return ApiResult.success(roleDomainService.pageList(pageListDTO));
    }

}

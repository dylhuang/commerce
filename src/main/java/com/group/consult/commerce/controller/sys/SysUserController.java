package com.group.consult.commerce.controller.sys;

import com.group.consult.commerce.model.ApiResult;
import com.group.consult.commerce.model.PageResult;
import com.group.consult.commerce.model.dto.UserAddDTO;
import com.group.consult.commerce.model.dto.UserEditDTO;
import com.group.consult.commerce.model.dto.UserListDTO;
import com.group.consult.commerce.model.vo.SysUserResetPwdDTO;
import com.group.consult.commerce.model.vo.UserDetailVO;
import com.group.consult.commerce.model.vo.UserListVO;
import com.group.consult.commerce.service.ISysUserDomainService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @title: 用户管理
 * @description: 用户管理
 * @author: zl
 * @date: 2024-08-12
 */
@RestController
@RequestMapping("/api/sys/user")
public class SysUserController {

    @Autowired
    private ISysUserDomainService userDomainService;

    @PostMapping("/add")
    @Operation(summary = "添加用户")
    public ApiResult<Boolean> add(@RequestBody @Valid UserAddDTO userAddDTO) {
        return ApiResult.success(userDomainService.add(userAddDTO));
    }

    @PutMapping("/edit")
    @Operation(summary = "编辑用户")
    public ApiResult<Boolean> edit(@RequestBody @Valid UserEditDTO userEditDTO) {
        return ApiResult.success(userDomainService.edit(userEditDTO));
    }

    @DeleteMapping("/remove")
    @Operation(summary = "删除用户")
    public ApiResult<Boolean> remove(@RequestParam("ids") List<Long> ids) {
        return ApiResult.success(userDomainService.remove(ids));
    }

    @PostMapping("/resetPwd")
    @Operation(summary = "重置密码")
    public ApiResult<Boolean> resetPwd(@RequestBody @Valid SysUserResetPwdDTO dto) {
        return ApiResult.success(userDomainService.resetPwd(dto));
    }

    @Operation(summary = "用户详情")
    @GetMapping("/fetchDetail")
    public ApiResult<UserDetailVO> fetchDetail(@RequestParam("id") Long id) {
        return ApiResult.success(userDomainService.fetchDetail(id));
    }

    @Operation(summary = "用户分页列表")
    @PostMapping("/pageList")
    public ApiResult<PageResult<UserListVO>> pageList(@RequestBody UserListDTO dto) {
        return ApiResult.success(userDomainService.pageList(dto));
    }

}

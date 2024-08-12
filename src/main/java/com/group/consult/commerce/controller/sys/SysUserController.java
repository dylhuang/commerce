package com.group.consult.commerce.controller.sys;

import com.group.consult.commerce.model.ApiResult;
import com.group.consult.commerce.model.dto.UserAddDTO;
import com.group.consult.commerce.model.dto.UserEditDTO;
import com.group.consult.commerce.service.ISysUserDomainService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/edit")
    @Operation(summary = "编辑用户")
    public ApiResult<Boolean> edit(@RequestBody @Valid UserEditDTO userEditDTO) {
        return ApiResult.success(userDomainService.edit(userEditDTO));
    }
}

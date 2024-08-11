package com.group.consult.commerce.controller.sys;

import com.group.consult.commerce.configuration.interceptors.LoginUser;
import com.group.consult.commerce.model.ApiResult;
import com.group.consult.commerce.model.dto.LoginDTO;
import com.group.consult.commerce.model.vo.LoginVO;
import com.group.consult.commerce.model.vo.RoutersVO;
import com.group.consult.commerce.model.vo.UserInfoVO;
import com.group.consult.commerce.service.ISysLoginDomainService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @title: 登录控制器
 * @description: 登录控制器
 * @author: zl
 * @date: 2024-08-08
 */
@Slf4j
@RestController
@RequestMapping("/api/sys")
public class LoginController {

    @Autowired
    private ISysLoginDomainService loginDomainService;

    /**
     * 登录
     * @param loginDTO
     * @return
     */
    @PostMapping("/login")
    @Operation(summary = "登录")
    public ApiResult<LoginVO> login(@RequestBody @Valid LoginDTO loginDTO) {
        String token = loginDomainService.login(loginDTO);
        LoginVO loginVO = new LoginVO();
        loginVO.setToken(token);
        return ApiResult.success(loginVO);
    }

    @GetMapping("/getUser")
    @Operation(summary = "获取登录用户信息")
    public ApiResult<UserInfoVO> getUser() {
        //获取登录用户信息
        LoginUser loginUser = LoginUser.getLoginSubject();
        //查询用户信息
        UserInfoVO userInfoVO = loginDomainService.getUserInfo(loginUser.getUserName());
        return ApiResult.success(userInfoVO);
    }

    @GetMapping("/getRouters")
    @Operation(summary = "获取路由信息")
    public ApiResult<List<RoutersVO>> getRouters() {
        LoginUser loginUser = LoginUser.getLoginSubject();
        List<RoutersVO> list = loginDomainService.getRouters(loginUser.getUserName());
        return ApiResult.success(list);
    }

}

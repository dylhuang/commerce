package com.group.consult.commerce.controller.sys;

import com.group.consult.commerce.model.ApiResult;
import com.group.consult.commerce.model.dto.LoginDTO;
import com.group.consult.commerce.model.vo.LoginVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    /**
     * 登录
     * @param loginDTO
     * @return
     */
    @PostMapping("/login")
    public ApiResult<LoginVO> login(@RequestBody LoginDTO loginDTO) {
        return null;
    }

}

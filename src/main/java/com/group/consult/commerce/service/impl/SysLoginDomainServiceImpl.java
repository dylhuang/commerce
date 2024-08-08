package com.group.consult.commerce.service.impl;

import com.group.consult.commerce.dao.entity.SysCaptchaCode;
import com.group.consult.commerce.dao.entity.SysUser;
import com.group.consult.commerce.model.dto.LoginDTO;
import com.group.consult.commerce.persist.ISysCaptchaCodeService;
import com.group.consult.commerce.persist.ISysUserService;
import com.group.consult.commerce.service.ISysLoginDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @title: 系统登录
 * @description: 系统登录
 * @author: zl
 * @date: 2024-08-08
 */
@Service
public class SysLoginDomainServiceImpl implements ISysLoginDomainService {

    @Autowired
    private ISysUserService userService;

    @Autowired
    private ISysCaptchaCodeService captchaCodeService;

    @Override
    public String login(LoginDTO dto) {

        //校验验证码
        SysCaptchaCode captchaCode = captchaCodeService.queryByUuid(dto.getUuid());
        if (captchaCode == null) {

        }
        dto.getCode().equals(captchaCode.getCode());
        //校验用户密码

        SysUser sysUser = userService.findByUserName(dto.getUsername());

        return null;
    }
}

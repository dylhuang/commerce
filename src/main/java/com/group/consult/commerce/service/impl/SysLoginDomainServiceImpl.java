package com.group.consult.commerce.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.crypto.digest.MD5;
import com.group.consult.commerce.configuration.Constants;
import com.group.consult.commerce.dao.entity.SysCaptchaCode;
import com.group.consult.commerce.dao.entity.SysUser;
import com.group.consult.commerce.model.ApiCodeEnum;
import com.group.consult.commerce.model.dto.CaptchDTO;
import com.group.consult.commerce.model.dto.LoginDTO;
import com.group.consult.commerce.persist.ISysCaptchaCodeService;
import com.group.consult.commerce.persist.ISysUserService;
import com.group.consult.commerce.service.ISysLoginDomainService;
import com.group.consult.commerce.utils.GerneralUtil;
import org.springframework.beans.BeanUtils;
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

        //1、校验验证码
        SysCaptchaCode captchaCode = captchaCodeService.queryByUuid(dto.getUuid());
        //验证码已过期
        GerneralUtil.assertCheck(captchaCode != null, ApiCodeEnum.CAPTCHA_EXPIRED);
        //验证码错误
        GerneralUtil.assertCheck(dto.getCode().equals(captchaCode.getCode()), ApiCodeEnum.CAPTCHA_EXPIRED);

        //2、校验用户密码
        SysUser sysUser = userService.findByUserName(dto.getUsername());
        GerneralUtil.assertCheck(sysUser != null, ApiCodeEnum.USER_PWD_ERROR);
        GerneralUtil.assertCheck(Constants.ZERO.equals(sysUser.getStatus()), ApiCodeEnum.USER_STATUS_ERROR);
        //todo 用户密码校验
        //todo 生成token
        return "mock-token";
    }

    @Override
    public void saveAndClearCaptchaCode(CaptchDTO captchDTO) {
        SysCaptchaCode captchaCode = new SysCaptchaCode();
        BeanUtil.copyProperties(captchDTO, captchaCode);
        captchaCodeService.saveAndClearCaptchaCode(captchaCode);
    }
}

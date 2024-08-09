package com.group.consult.commerce.service;

import com.group.consult.commerce.model.dto.CaptchDTO;
import com.group.consult.commerce.model.dto.LoginDTO;

/**
 * @title: 系统登录
 * @description: 系统登录
 * @author: zl
 * @date: 2024-08-08
 */
public interface ISysLoginDomainService {

    /**
     * 登录信息
     * @param dto
     * @return token
     */
    String login(LoginDTO dto);

    /**
     * 存储并清理验证码
     * @param captchDTO
     */
    void saveAndClearCaptchaCode(CaptchDTO captchDTO);
}

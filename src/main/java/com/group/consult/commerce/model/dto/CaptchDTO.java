package com.group.consult.commerce.model.dto;

import lombok.Data;

import java.util.Date;

/**
 * @title: 验证码
 * @description: 验证码
 * @author: zl
 * @date: 2024-08-09
 */
@Data
public class CaptchDTO {

    /**
     * 验证码
     */
    private String code;

    /**
     * uuid
     */
    private String uuid;

    /**
     * 过期时间
     */
    private Date expireTime;
}

package com.group.consult.commerce.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @title: 登录用户信息
 * @description: 登录用户信息
 * @author: zl
 * @date: 2024-08-08
 */
@Data
@Schema(description = "登录信息")
public class LoginVO {

    @Schema(description = "token")
    private String token;
}

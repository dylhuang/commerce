package com.group.consult.commerce.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * @title: 登录请求
 * @description: 登录请求
 * @author: zl
 * @date: 2024-08-08
 */
@Data
public class LoginDTO {

    /**
     * 用户名
     */
    @Schema(description = "用户名")
    @NotBlank(message = "用户名必填")
    private String username;

    /**
     * 用户密码
     */
    @Schema(description = "用户密码")
    @NotBlank(message = "用户密码必填")
    private String password;

    /**
     * 验证码
     */
    @Schema(description = "验证码")
    @NotBlank(message = "验证码必填")
    private String code;

    /**
     * 唯一标识
     */
    @Schema(description = "uuid")
    @NotBlank(message = "uuid必填")
    private String uuid;
}

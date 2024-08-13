package com.group.consult.commerce.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * @title: 用户密码重置
 * @description: 用户密码重置
 * @author: zl
 * @date: 2024-08-13
 */
@Schema(description = "用户密码重置")
@Data
public class SysUserResetPwdDTO {

    @NotBlank(message = "标识必填")
    @Schema(description = "标识")
    private String id;

    @NotBlank(message = "密码必填")
    @Schema(description = "密码")
    private String password;
}

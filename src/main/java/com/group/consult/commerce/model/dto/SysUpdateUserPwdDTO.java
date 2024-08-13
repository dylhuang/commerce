package com.group.consult.commerce.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * @title: 修改登录用户密码
 * @description: 修改登录用户密码
 * @author: zl
 * @date: 2024-08-13
 */
@Schema(description = "修改登录用户密码")
@Data
public class SysUpdateUserPwdDTO {

    @NotBlank(message = "原密码必填")
    @Schema(description = "原密码")
    private String oldPwd ;

    @NotBlank(message = "新密码必填")
    @Schema(description = "新密码")
    private String newPwd ;
}

package com.group.consult.commerce.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @title: 验证码响应
 * @description: 验证码响应
 * @author: zl
 * @date: 2024-08-08
 */
@Data
@Schema(description = "验证码VO")
public class CaptchaVO {

    @Schema(description = "uuid")
    private String uuid;

    @Schema(description = "图片base64")
    private String img;
}

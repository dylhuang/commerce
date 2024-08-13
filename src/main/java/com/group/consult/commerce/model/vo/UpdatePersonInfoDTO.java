package com.group.consult.commerce.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @title: 个人信息修改
 * @description: 个人信息修改
 * @author: zl
 * @date: 2024-08-13
 */
@Schema(description = "个人信息修改")
@Data
public class UpdatePersonInfoDTO {
    @Schema(description = "昵称")
    private String nickName ;

    @Schema(description = "邮箱")
    private String email ;

    @Schema(description = "电话")
    private String phone ;

    @Schema(description = "性别（0男，1女）")
    private Integer gender ;
}

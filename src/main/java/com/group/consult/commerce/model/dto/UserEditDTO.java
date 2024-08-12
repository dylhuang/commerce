package com.group.consult.commerce.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.List;

/**
 * @title: 编辑用户
 * @description: 编辑用户
 * @author: zl
 * @date: 2024-08-12
 */
@Data
@Schema(description = "编辑用户")
public class UserEditDTO {

    @NotBlank(message = "标识必填")
    @Schema(description = "标识", required = true)
    private String id;

    @NotBlank(message = "用户名必填")
    @Schema(description = "用户名", required = true)
    private String userName ;

    @NotBlank(message = "密码必填")
    @Schema(description = "密码", required = true)
    private String password;

    @Schema(description = "昵称")
    private String nickName ;

    @Schema(description = "邮箱")
    private String email ;

    @Schema(description = "电话")
    private String phone ;

    @Schema(description = "性别（0男，1女）")
    private Integer gender ;

    @Schema(description = "备注")
    private String remark ;

    @NotEmpty(message = "角色id列表不能为空")
    @Schema(description = "角色id列表", required = true)
    private List<String> roleIds;
}

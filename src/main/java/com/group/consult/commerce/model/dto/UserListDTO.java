package com.group.consult.commerce.model.dto;

import com.group.consult.commerce.model.PageRequest;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @title: 用户列表查询
 * @description: 用户列表查询
 * @author: zl
 * @date: 2024-08-13
 */
@EqualsAndHashCode(callSuper = true)
@Schema(description = "用户列表查询")
@Data
public class UserListDTO extends PageRequest {

    @Schema(description = "用户号")
    private String userName ;

    @Schema(description = "昵称")
    private String nickName ;

    @Schema(description = "电话")
    private String phone ;

    @Schema(description = "用户状态(0-正常，1-禁用)")
    private Integer status ;
}

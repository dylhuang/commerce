package com.group.consult.commerce.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @title: 菜单列表查询
 * @description: 菜单列表查询
 * @author: zl
 * @date: 2024-08-12
 */
@Schema(description = "菜单列表查询")
@Data
public class SysMenuListDTO {

    @Schema(description = "父级标识")
    private String parentId ;

    @Schema(description = "菜单名称")
    private String menuName;
}

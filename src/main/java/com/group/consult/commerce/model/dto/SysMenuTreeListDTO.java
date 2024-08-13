package com.group.consult.commerce.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @title: 菜单树
 * @description: 菜单树
 * @author: zl
 * @date: 2024-08-13
 */
@Schema(description = "菜单树")
@Data
public class SysMenuTreeListDTO {

    @Schema(description = "父级标识")
    private String parentId ;

    @Schema(description = "菜单名称")
    private String menuName;
}

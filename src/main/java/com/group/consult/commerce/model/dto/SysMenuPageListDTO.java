package com.group.consult.commerce.model.dto;

import com.group.consult.commerce.model.PageRequest;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @title: 菜单列表查询
 * @description: 菜单列表查询
 * @author: zl
 * @date: 2024-08-12
 */
@EqualsAndHashCode(callSuper = true)
@Schema(description = "菜单列表查询")
@Data
public class SysMenuPageListDTO extends PageRequest {

    @Schema(description = "父级标识")
    private String parentId ;

    @Schema(description = "菜单名称")
    private String menuName;
}

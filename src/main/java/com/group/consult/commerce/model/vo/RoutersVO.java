package com.group.consult.commerce.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * @title: 路由
 * @description: 路由信息
 * @author: zl
 * @date: 2024-08-09
 */
@Data
@Schema(description = "路由")
public class RoutersVO {

    @Schema(description = "路由id")
    private String id;

    @Schema(description = "权限资源名称")
    private String menuName;

    @Schema(description = "权限资源代码")
    private String code;

    @Schema(description = "路由名称")
    private String routeName;

    @Schema(description = "组件名称")
    private String component;

    @Schema(description = "资源路径")
    private String path;

    @Schema(description = "子路由")
    private List<RoutersVO> children;
}

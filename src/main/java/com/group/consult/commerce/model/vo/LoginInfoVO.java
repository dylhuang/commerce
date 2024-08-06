package com.group.consult.commerce.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.Set;

/**
 * 登录信息VO
 *
 * @author lizisong
 * @since 2023/12/21
 */
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@Schema(description = "登录信息VO")
public class LoginInfoVO extends BaseVO {

    /**
     * 用户名
     */
    @Schema(description = "用户名")
    private String username;

    /**
     * 用户类型；0：内部用户；1：外部客户
     */
    @Schema(description = "用户类型；0：内部用户；1：外部客户")
    private Integer userType;

    /**
     * 是否为内部用户
     */
    @Schema(description = "是否为内部用户")
    private Boolean isInternalUser;

    /**
     * 是否为外部客户
     */
    @Schema(description = "是否为外部客户")
    private Boolean isExternalCustomer;

    /**
     * 是否在黑名单
     */
    @Schema(description = "是否在黑名单")
    private Boolean isOnBlackList;

    /**
     * 操作人名称
     */
    @Schema(description = "操作人名称")
    private String operatorName;

    /**
     * 角色列表
     */
    @Schema(description = "角色列表")
    private Set<String> roles;

    /**
     * 菜单列表
     */
    @Schema(description = "菜单列表")
    private Set<String> menus;

    /**
     * 按钮列表
     */
    @Schema(description = "按钮列表")
    private Set<String> buttons;

    /**
     * 权限列表
     */
//    @Schema(description = "权限列表")
//    private List<RolePermissionVO> permissions;

    /**
     * token
     */
    @Schema(description = "token")
    private String token;

    /**
     * 登录时间
     */
    @Schema(description = "登录时间")
    private LocalDateTime loginTime;

}

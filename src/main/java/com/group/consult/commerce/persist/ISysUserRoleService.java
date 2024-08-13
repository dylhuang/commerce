package com.group.consult.commerce.persist;

import com.baomidou.mybatisplus.extension.service.IService;
import com.group.consult.commerce.dao.entity.SysUserRole;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zl
 * @since 2024/08/08
 */
public interface ISysUserRoleService extends IService<SysUserRole> {

    /**
     * 统计用户角色关系数量
     * @param roleIds 角色id列表
     * @return
     */
    long countByRoleId(List<Long> roleIds);

    /**
     * 绑定用户角色关系
     * @param userId
     * @param roleIds
     */
    void bindUserRole(Long userId, List<Long> roleIds);


    /**
     * 删除用户角色关系
     * @param userId
     */
    int removeUserRole(Long userId);

    /**
     * 删除多个用户的角色关系
     * @param userIds
     * @return 删除条数
     */
    int removeBatchUserRole(List<Long> userIds);

}

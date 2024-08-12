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

}

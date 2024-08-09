package com.group.consult.commerce.persist;

import com.group.consult.commerce.dao.entity.SysRole;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zl
 * @since 2024/08/08
 */
public interface ISysRoleService extends IService<SysRole> {

    /**
     * 获取用户的角色列表
     * @param userId
     * @return
     */
    List<SysRole> listByUserId(Long userId);
}

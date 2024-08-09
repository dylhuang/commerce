package com.group.consult.commerce.persist;

import com.group.consult.commerce.dao.entity.SysMenu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Set;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zl
 * @since 2024/08/08
 */
public interface ISysMenuService extends IService<SysMenu> {

    /**
     * 根据用户id获取用户权限
     * @param userId
     * @return
     */
    List<SysMenu> findByUserId(Long userId);

    /**
     * 根据用户id获取路由菜单信息
     * @param userId
     * @return
     */
    List<SysMenu> findRoutersByUserId(Long userId);
}

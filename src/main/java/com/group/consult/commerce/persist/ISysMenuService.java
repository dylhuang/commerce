package com.group.consult.commerce.persist;

import com.group.consult.commerce.dao.entity.SysMenu;
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
public interface ISysMenuService extends IService<SysMenu> {

    /**
     * 根据用户id获取用户权限
     * @param userId
     * @return
     */
    List<SysMenu> findByUserId(Long userId);
}

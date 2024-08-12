package com.group.consult.commerce.persist;

import com.baomidou.mybatisplus.extension.service.IService;
import com.group.consult.commerce.dao.entity.SysMenu;
import com.group.consult.commerce.dao.entity.SysRoleMenu;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zl
 * @since 2024/08/08
 */
public interface ISysRoleMenuService extends IService<SysRoleMenu> {

    /**
     * 统计正在使用的菜单数量
     * @param menuIds
     * @return
     */
    Long countUsedMenu(List<Long> menuIds);

    /**
     * 绑定角色菜单关系
     * @param roleId
     * @param menuIds
     */
    void bindRoleMenu(Long roleId, List<Long> menuIds);

    /**
     * 删除多个角色菜单关系
     * @param roleIds
     * @return 删除条数
     */
    int removeBatchRoleMenu(List<Long> roleIds);

    /**
     * 查询指定角色的菜单列表
     * @param roleId
     * @return
     */
    List<SysMenu> listMenuByRoleId(Long roleId);

}

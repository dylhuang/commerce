package com.group.consult.commerce.persist;

import com.group.consult.commerce.dao.entity.SysRoleMenu;
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
public interface ISysRoleMenuService extends IService<SysRoleMenu> {

    /**
     * 统计正在使用的菜单数量
     * @param menuIds
     * @return
     */
    Long countUsedMenu(List<Long> menuIds);

}

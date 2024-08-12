package com.group.consult.commerce.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.group.consult.commerce.dao.entity.SysMenu;
import com.group.consult.commerce.dao.entity.SysRoleMenu;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zl
 * @since 2024/08/08
 */
public interface SysRoleMenuMapper extends BaseMapper<SysRoleMenu> {

    /**
     * 查询指定角色的菜单列表
     * @param roleId
     * @return
     */
    @Select("select distinct m.* from sys_menu m \n"
            + "left join sys_role_menu rm on m.id = rm.menu_id\n"
            + "where rm.role_id = #{roleId}")
    List<SysMenu> queryMenuByRoleId(@Param("roleId") Long roleId);
}

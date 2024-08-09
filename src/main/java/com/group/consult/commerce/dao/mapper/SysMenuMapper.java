package com.group.consult.commerce.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.group.consult.commerce.dao.entity.SysMenu;
import com.group.consult.commerce.dao.entity.SysUser;
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
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    @Select("select DISTINCT m.* from sys_menu m \n" +
            "inner join sys_role_menu rm on m.id = rm.menu_id\n" +
            "inner join sys_user_role ur on ur.role_id = rm.role_id\n" +
            "where ur.user_id = #{userId}")
    List<SysMenu> findByUserId(Long userId);
}

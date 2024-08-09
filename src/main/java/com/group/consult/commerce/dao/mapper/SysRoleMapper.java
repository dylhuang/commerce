package com.group.consult.commerce.dao.mapper;

import com.group.consult.commerce.dao.entity.SysRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
public interface SysRoleMapper extends BaseMapper<SysRole> {

    @Select("select DISTINCT r.* from sys_role r left join sys_user_role ur on r.id = ur.role_id\n"
            + "where user_id = #{userId}")
    List<SysRole> findByUserId(@Param("userId") Long userId);
}

package com.group.consult.commerce.dao.mapper;

import com.group.consult.commerce.dao.entity.SysUserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zl
 * @since 2024/08/08
 */
public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {

    /**
     * 删除用户角色之间的绑定关系
     * @param userId
     * @return
     */
    @Delete("delete from sys_user_role where user_id = #{userId}")
    int deleteUserRole(@Param("userId") Long userId);

}

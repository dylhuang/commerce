package com.group.consult.commerce.persist;

import com.group.consult.commerce.dao.entity.SysRole;
import com.baomidou.mybatisplus.extension.service.IService;
import com.group.consult.commerce.model.PageResult;
import com.group.consult.commerce.model.dto.RolePageListDTO;
import com.group.consult.commerce.model.vo.RoleListVO;

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

    /**
     * 角色列表分页
     * @param pageListDTO
     * @return
     */
    PageResult<RoleListVO> pageList(RolePageListDTO pageListDTO);
}

package com.group.consult.commerce.persist;

import com.baomidou.mybatisplus.extension.service.IService;
import com.group.consult.commerce.dao.entity.SysMenu;
import com.group.consult.commerce.model.PageResult;
import com.group.consult.commerce.model.dto.SysMenuListDTO;
import com.group.consult.commerce.model.dto.SysMenuPageListDTO;
import com.group.consult.commerce.model.dto.SysMenuTreeListDTO;
import com.group.consult.commerce.model.vo.SysMenuListVO;
import com.group.consult.commerce.model.vo.SysMenuPageListVO;
import com.group.consult.commerce.model.vo.SysMenuTreeListVO;

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

    /**
     * 根据用户id获取路由菜单信息
     * @param userId
     * @return
     */
    List<SysMenu> findRoutersByUserId(Long userId);

    /**
     * 统计给定菜单下的子菜单数量
     * @param ids 菜单id列表
     * @return
     */
    Long countChilds(List<Long> ids);

    /**
     * 列表，不分页
     * @param dto
     * @return
     */
    List<SysMenuListVO> listNoPage(SysMenuListDTO dto);

    /**
     * 列表，分页
     * @param dto
     * @return
     */
    PageResult<SysMenuPageListVO> pageList(SysMenuPageListDTO dto);

    /**
     * 菜单树
     * @param dto
     * @return
     */
    List<SysMenuTreeListVO> treeList(SysMenuTreeListDTO dto);

}

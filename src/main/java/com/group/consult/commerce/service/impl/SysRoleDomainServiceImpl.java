package com.group.consult.commerce.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.group.consult.commerce.dao.entity.SysMenu;
import com.group.consult.commerce.dao.entity.SysRole;
import com.group.consult.commerce.model.ApiCodeEnum;
import com.group.consult.commerce.model.PageResult;
import com.group.consult.commerce.model.dto.RoleAddDTO;
import com.group.consult.commerce.model.dto.RoleEditDTO;
import com.group.consult.commerce.model.dto.RolePageListDTO;
import com.group.consult.commerce.model.vo.RoleDetailVO;
import com.group.consult.commerce.model.vo.RoleListVO;
import com.group.consult.commerce.persist.ISysRoleMenuService;
import com.group.consult.commerce.persist.ISysRoleService;
import com.group.consult.commerce.persist.ISysUserRoleService;
import com.group.consult.commerce.service.ISysRoleDomainService;
import com.group.consult.commerce.utils.GerneralUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @title: 标题
 * @description: 描述
 * @author: zl
 * @date: 2024-08-12
 */
@Service
public class SysRoleDomainServiceImpl implements ISysRoleDomainService {

    @Autowired
    private ISysRoleService roleService;

    @Autowired
    private ISysRoleMenuService roleMenuService;

    @Autowired
    private ISysUserRoleService userRoleService;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Boolean add(RoleAddDTO roleAddDTO) {
        List<Long> menuIds = roleAddDTO.getMenuIds().stream()
                .map(item -> Long.valueOf(item)).collect(Collectors.toList());

        //编码唯一校验
        SysRole roleCheck = getByRoleCode(roleAddDTO.getRoleCode());
        GerneralUtil.assertCheck(roleCheck == null, ApiCodeEnum.ROLE_CODE_EXIST);

        SysRole role = new SysRole();
        BeanUtil.copyProperties(roleAddDTO, role);
        boolean resSave = roleService.save(role);

        GerneralUtil.assertCheck(resSave, ApiCodeEnum.ROLE_SAVE_ERROR);
        roleMenuService.bindRoleMenu(role.getId(), menuIds);
        return Boolean.TRUE;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Boolean edit(RoleEditDTO roleEditDTO) {
        List<Long> menuIds = roleEditDTO.getMenuIds().stream()
                .map(item -> Long.valueOf(item)).collect(Collectors.toList());

        //编码唯一校验
        SysRole roleCheck = getByRoleCode(roleEditDTO.getRoleCode());
        //是否为自己的编码
        boolean isSelf = roleCheck != null && roleCheck.getId().equals(Long.valueOf(roleEditDTO.getId()));
        GerneralUtil.assertCheck(roleCheck == null || isSelf, ApiCodeEnum.ROLE_CODE_EXIST);

        SysRole role = new SysRole();
        BeanUtil.copyProperties(roleEditDTO, role);
        boolean resSave = roleService.updateById(role);

        GerneralUtil.assertCheck(resSave, ApiCodeEnum.ROLE_SAVE_ERROR);
        roleMenuService.removeRoleMenu(role.getId());
        roleMenuService.bindRoleMenu(role.getId(), menuIds);
        return Boolean.TRUE;
    }

    /**
     * 根据code获取角色
     * @param roleCode
     * @return
     */
    private SysRole getByRoleCode(String roleCode) {
        return roleService.getBaseMapper()
                .selectOne(new QueryWrapper<SysRole>()
                        .lambda()
                        .eq(SysRole::getRoleCode, roleCode));
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Boolean remove(List<Long> ids) {
        //检查角色是否有使用
        long countUserRoles = userRoleService.countByRoleId(ids);
        GerneralUtil.check(countUserRoles > 0, ApiCodeEnum.ROLE_USING);
        //删除角色菜单关系
        roleMenuService.removeBatchRoleMenu(ids);
        //删除角色
        return roleService.removeByIds(ids);
    }

    @Override
    public RoleDetailVO fetchDetail(Long id) {
        SysRole role = roleService.getById(id);
        if (role == null) {
            return null;
        }
        RoleDetailVO resultDto = new RoleDetailVO();
        BeanUtil.copyProperties(role, resultDto);
        List<SysMenu> menus = roleMenuService.listMenuByRoleId(id);
        List<String> menuIds = menus.stream().map(item -> item.getId().toString())
                .collect(Collectors.toList());
        resultDto.setMenuIds(menuIds);
        return resultDto;
    }

    @Override
    public PageResult<RoleListVO> pageList(RolePageListDTO dto) {
        return roleService.pageList(dto);
    }
}

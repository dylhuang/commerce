package com.group.consult.commerce.persist.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.group.consult.commerce.dao.entity.SysRole;
import com.group.consult.commerce.dao.mapper.SysRoleMapper;
import com.group.consult.commerce.model.PageResult;
import com.group.consult.commerce.model.dto.RolePageListDTO;
import com.group.consult.commerce.model.vo.RoleListVO;
import com.group.consult.commerce.persist.ISysRoleService;
import com.group.consult.commerce.utils.SqlUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zl
 * @since 2024/08/08
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {
    @Override
    public List<SysRole> listByUserId(Long userId) {
        return this.getBaseMapper().findByUserId(userId);
    }

    @Override
    public PageResult<RoleListVO> pageList(RolePageListDTO pageListDTO) {
        pageListDTO.initWithUpdateTimeSort();
        LambdaQueryWrapper<SysRole> wrapper = Wrappers.lambdaQuery();
        if (StringUtils.isNotEmpty(pageListDTO.getRoleCode())) {
            wrapper.eq(SysRole::getRoleCode, pageListDTO.getRoleCode());
        }
        if (StringUtils.isNotEmpty(pageListDTO.getRoleName())) {
            wrapper.like(SysRole::getRoleName, pageListDTO.getRoleName());
        }
        SqlUtils.commonOrderBy(pageListDTO.getSorts(), wrapper);
        Page<SysRole> page = this.page(Page.of(pageListDTO.getPageNum(),pageListDTO.getPageSize()), wrapper);
        List<RoleListVO> list = page.getRecords().stream().map(item -> {
            RoleListVO roleListVO = new RoleListVO();
            BeanUtil.copyProperties(item, roleListVO);
            return roleListVO;
        }).collect(Collectors.toList());

        return PageResult.of(list, page);
    }
}

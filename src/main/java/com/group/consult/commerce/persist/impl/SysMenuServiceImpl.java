package com.group.consult.commerce.persist.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.group.consult.commerce.dao.entity.SysMenu;
import com.group.consult.commerce.dao.mapper.SysMenuMapper;
import com.group.consult.commerce.model.PageResult;
import com.group.consult.commerce.model.dto.SysMenuListDTO;
import com.group.consult.commerce.model.dto.SysMenuPageListDTO;
import com.group.consult.commerce.model.dto.SysMenuTreeListDTO;
import com.group.consult.commerce.model.vo.SysMenuListVO;
import com.group.consult.commerce.model.vo.SysMenuPageListVO;
import com.group.consult.commerce.model.vo.SysMenuTreeListVO;
import com.group.consult.commerce.persist.ISysMenuService;
import com.group.consult.commerce.utils.SqlUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author zl
 * @since 2024/08/08
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements ISysMenuService {
    @Override
    public List<SysMenu> findByUserId(Long userId) {
        return getBaseMapper().findByUserId(userId);
    }

    @Override
    public List<SysMenu> findRoutersByUserId(Long userId) {
        return getBaseMapper().findRouterByUserId(userId);
    }

    @Override
    public Long countChilds(List<Long> ids) {
        QueryWrapper<SysMenu> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().in(SysMenu::getParentId, ids);
        return this.count(queryWrapper);
    }

    @Override
    public List<SysMenuListVO> listNoPage(SysMenuListDTO dto) {
        QueryWrapper<SysMenu> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().orderByAsc(SysMenu::getParentId, SysMenu::getOrderNum);

        if (StringUtils.isNotBlank(dto.getParentId())) {
            queryWrapper.lambda().eq(SysMenu::getParentId, dto.getParentId());
        }
        if (StringUtils.isNotBlank(dto.getMenuName())) {
            queryWrapper.lambda().like(SysMenu::getMenuName, dto.getMenuName());
        }

        List<SysMenu> menuList = this.getBaseMapper().selectList(queryWrapper);
        List<SysMenuListVO> list = menuList.stream().map(item -> {
            SysMenuListVO resultDto = new SysMenuListVO();
            BeanUtil.copyProperties(item, resultDto);
            return resultDto;
        }).collect(Collectors.toList());
        return list;
    }

    @Override
    public PageResult<SysMenuPageListVO> pageList(SysMenuPageListDTO dto) {
        dto.initWithUpdateTimeSort();
        LambdaQueryWrapper<SysMenu> wrapper = Wrappers.lambdaQuery();
        if (StringUtils.isNotBlank(dto.getParentId())) {
            wrapper.eq(SysMenu::getParentId, dto.getParentId());
        }
        if (StringUtils.isNotBlank(dto.getMenuName())) {
            wrapper.like(SysMenu::getMenuName, dto.getMenuName());
        }
        SqlUtils.commonOrderBy(dto.getSorts(), wrapper);

        Page<SysMenu> page = this.page(Page.of(dto.getPageNum(), dto.getPageSize()), wrapper);
        List<SysMenuPageListVO> list = page.getRecords().stream().map(item -> {
            SysMenuPageListVO pageListVO = new SysMenuPageListVO();
            BeanUtil.copyProperties(item, pageListVO);
            return pageListVO;
        }).collect(Collectors.toList());

        return PageResult.of(list, page);
    }

    @Override
    public List<SysMenuTreeListVO> treeList(SysMenuTreeListDTO dto) {
        LambdaQueryWrapper<SysMenu> wrapper = Wrappers.lambdaQuery();
        if (StringUtils.isNotBlank(dto.getParentId())) {
            wrapper.eq(SysMenu::getParentId, dto.getParentId());
        }
        if (StringUtils.isNotBlank(dto.getMenuName())) {
            wrapper.like(SysMenu::getMenuName, dto.getMenuName());
        }
        List<SysMenu> sysMenus = this.list(wrapper);

        return buildTreeList(0L, sysMenus);
    }

    private List<SysMenuTreeListVO> buildTreeList(Long parentId, List<SysMenu> sysMenus) {
        return sysMenus.stream().filter(item -> parentId.equals(item.getParentId())).map(item -> {
            SysMenuTreeListVO listVO = new SysMenuTreeListVO();
            BeanUtil.copyProperties(item, listVO);
            listVO.setChildren(buildTreeList(item.getId(), sysMenus));
            return listVO;
        }).collect(Collectors.toList());
    }
}

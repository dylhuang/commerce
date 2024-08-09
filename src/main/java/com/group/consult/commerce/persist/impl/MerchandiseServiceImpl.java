package com.group.consult.commerce.persist.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.group.consult.commerce.dao.entity.Merchandise;
import com.group.consult.commerce.dao.mapper.MerchandiseMapper;
import com.group.consult.commerce.exception.BusinessException;
import com.group.consult.commerce.model.ApiCodeEnum;
import com.group.consult.commerce.model.PageResult;
import com.group.consult.commerce.model.dto.MerchandisePageableDTO;
import com.group.consult.commerce.model.vo.MerchandiseVO;
import com.group.consult.commerce.persist.IMerchandiseService;
import com.group.consult.commerce.utils.SqlUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 商品表 服务实现类
 *
 * @author Huang, Dylan Bo
 * @since 2024/08/07
 */
@Service
public class MerchandiseServiceImpl extends ServiceImpl<MerchandiseMapper, Merchandise> implements IMerchandiseService {

    @Override
    public Merchandise getMerchandiseById(long merchandiseId) throws BusinessException {
        try {
            return this.getById(merchandiseId);
        } catch (Exception e) {
            throw new BusinessException(ApiCodeEnum.SYSTEM_ERROR, e.getMessage());
        }
    }

    @Override
    public Merchandise getMerchandiseByIdNotNull(long merchandiseId) throws BusinessException {
        Merchandise entity = this.getMerchandiseById(merchandiseId);
        if(null == entity) {
            throw new BusinessException(ApiCodeEnum.MERCHANDISE_QUERY_NOT_NULL);
        }
        return entity;
    }

    @Override
    public boolean insertMerchandise(Merchandise merchandise) throws BusinessException {
        try {
            return this.saveOrUpdate(merchandise);
        } catch (Exception e) {
            throw new BusinessException(ApiCodeEnum.SYSTEM_ERROR, e.getMessage());
        }
    }

    @Override
    public boolean updateMerchandise(Merchandise merchandise) throws BusinessException {
        try {
            return this.updateById(merchandise);
        } catch (Exception e) {
            throw new BusinessException(ApiCodeEnum.SYSTEM_ERROR, e.getMessage());
        }
    }

    @Override
    public PageResult<MerchandiseVO> getMerchandiseList(MerchandisePageableDTO pageableDTO) throws BusinessException {
        try {
            pageableDTO.initWithUpdateTimeSort();
            LambdaQueryWrapper<Merchandise> wrapper = Wrappers.lambdaQuery();
            Optional.ofNullable(pageableDTO.getMerchandiseCode())
                    .filter(StringUtils::isNotEmpty)
                    .ifPresent(o -> wrapper.like(Merchandise::getMerchandiseCode, o));
            Optional.ofNullable(pageableDTO.getMerchandiseName())
                    .filter(StringUtils::isNotEmpty)
                    .ifPresent(o -> wrapper.like(Merchandise::getMerchandiseName, o));
            Optional.ofNullable(pageableDTO.getStatus())
                    .filter(StringUtils::isNotEmpty)
                    .ifPresent(o -> wrapper.eq(Merchandise::getStatus, o));
            SqlUtils.commonOrderBy(pageableDTO.getSorts(), wrapper);
            Page<Merchandise> page = this.page(Page.of(pageableDTO.getPageNum(), pageableDTO.getPageSize()), wrapper);
            List<MerchandiseVO> resultList = page.getRecords().stream().map(MerchandiseVO::of).collect(Collectors.toList());
            return PageResult.of(resultList, page);
        } catch (Exception e) {
            throw new BusinessException(ApiCodeEnum.SYSTEM_ERROR, e.getMessage());
        }
    }
}

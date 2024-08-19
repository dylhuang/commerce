package com.group.consult.commerce.persist.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.group.consult.commerce.dao.entity.ImageSpace;
import com.group.consult.commerce.dao.mapper.ImageSpaceMapper;
import com.group.consult.commerce.exception.BusinessException;
import com.group.consult.commerce.model.ApiCodeEnum;
import com.group.consult.commerce.model.PageResult;
import com.group.consult.commerce.model.dto.ImageSpacePageableDTO;
import com.group.consult.commerce.model.vo.ImageSpaceVO;
import com.group.consult.commerce.persist.IImageSpaceService;
import com.group.consult.commerce.utils.SqlUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * <p>
 * 图像空间 服务实现类
 * </p>
 *
 * @author Huang, Dylan Bo
 * @since 2024/08/19
 */
@Service
public class ImageSpaceServiceImpl extends ServiceImpl<ImageSpaceMapper, ImageSpace> implements IImageSpaceService {

    @Override
    public boolean insertImageSpace(ImageSpace imageSpace) throws BusinessException {
        try {
            return this.saveOrUpdate(imageSpace);
        } catch (Exception e) {
            throw new BusinessException(ApiCodeEnum.SYSTEM_ERROR, e.getMessage());
        }
    }

    @Override
    public boolean updateImageSpace(ImageSpace imageSpace) throws BusinessException {
        try {
            return this.updateById(imageSpace);
        } catch (Exception e) {
            throw new BusinessException(ApiCodeEnum.SYSTEM_ERROR, e.getMessage());
        }
    }

    @Override
    public ImageSpace getImageSpaceById(long imageId) throws BusinessException {
        try {
            return this.getById(imageId);
        } catch (Exception e) {
            throw new BusinessException(ApiCodeEnum.SYSTEM_ERROR, e.getMessage());
        }
    }

    @Override
    public ImageSpace getImageSpaceByIdNotNull(long imageId) throws BusinessException {
        ImageSpace entity = this.getImageSpaceById(imageId);
        if (null == entity) {
            throw new BusinessException(ApiCodeEnum.IMAGE_QUERY_NOT_NULL);
        }
        return entity;
    }

    @Override
    public PageResult<ImageSpaceVO> getPageableImageSpaceList(ImageSpacePageableDTO pageableDTO) throws BusinessException {
        try {
            pageableDTO.initWithUpdateTimeSort();
            LambdaQueryWrapper<ImageSpace> wrapper = Wrappers.lambdaQuery();
            Optional.ofNullable(pageableDTO.getName())
                    .filter(StringUtils::isNotEmpty)
                    .ifPresent(o -> wrapper.like(ImageSpace::getName, o));
            Optional.ofNullable(pageableDTO.getType())
                    .filter(StringUtils::isNotEmpty)
                    .ifPresent(o -> wrapper.eq(ImageSpace::getType, o));
            Optional.ofNullable(pageableDTO.getStatus())
                    .filter(StringUtils::isNotEmpty)
                    .ifPresent(o -> wrapper.eq(ImageSpace::getStatus, o));
            SqlUtils.commonOrderBy(pageableDTO.getSorts(), wrapper);
            Page<ImageSpace> page = this.page(Page.of(pageableDTO.getPageNum(), pageableDTO.getPageSize()), wrapper);
            List<ImageSpaceVO> resultList = page.getRecords().stream().map(ImageSpaceVO::of).collect(Collectors.toList());
            return PageResult.of(resultList, page);
        } catch (Exception e) {
            throw new BusinessException(ApiCodeEnum.SYSTEM_ERROR, e.getMessage());
        }
    }
}

package com.group.consult.commerce.service.impl;

import com.group.consult.commerce.dao.entity.ImageSpace;
import com.group.consult.commerce.exception.BusinessException;
import com.group.consult.commerce.model.ApiCodeEnum;
import com.group.consult.commerce.model.PageResult;
import com.group.consult.commerce.model.dto.ImageSpaceAdditionDTO;
import com.group.consult.commerce.model.dto.ImageSpaceEditionDTO;
import com.group.consult.commerce.model.dto.ImageSpacePageableDTO;
import com.group.consult.commerce.model.vo.ImageSpaceVO;
import com.group.consult.commerce.persist.IImageSpaceService;
import com.group.consult.commerce.service.IGlobalDomainService;
import com.group.consult.commerce.utils.BeanCopyUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Service
@RequiredArgsConstructor
public class GlobalDomainServiceImpl implements IGlobalDomainService {

    @Autowired
    private IImageSpaceService imageSpaceService;

    @Override
    public boolean addImageSpaceInfo(ImageSpaceAdditionDTO imageSpaceAdditionDTO) throws BusinessException {
        ImageSpace imageSpace = BeanCopyUtils.copy(imageSpaceAdditionDTO, ImageSpace.class);
        return imageSpaceService.insertImageSpace(imageSpace);
    }

    @Override
    public String addImageToOss(MultipartFile file) throws BusinessException {
        return "/oss/commerce/" + file.getName();
    }

    @Override
    public boolean editImageSpaceById(ImageSpaceEditionDTO imageSpaceEditionDTO) throws BusinessException {
        Long imageId = imageSpaceEditionDTO.getImageId();
        ImageSpace entity = imageSpaceService.getImageSpaceByIdNotNull(imageId);
        entity.setName(imageSpaceEditionDTO.getName());
        entity.setDescription(imageSpaceEditionDTO.getDescription());
        entity.setType(imageSpaceEditionDTO.getType());
        entity.setImageUrl(imageSpaceEditionDTO.getImageUrl());
        return imageSpaceService.updateImageSpace(entity);
    }

    @Override
    public boolean deleteImageSpaceById(long imageId) throws BusinessException {
        imageSpaceService.getImageSpaceByIdNotNull(imageId);
        try {
            return imageSpaceService.removeById(imageId);
        } catch (Exception e) {
            throw new BusinessException(ApiCodeEnum.SYSTEM_ERROR, e.getMessage());
        }
    }

    @Override
    public boolean ableMerchandiseById(long imageId) throws BusinessException {
        ImageSpace entity = imageSpaceService.getImageSpaceByIdNotNull(imageId);
        try {
            Integer status = entity.getStatus();
            if (status == 1) {
                entity.setStatus(0);
            } else {
                entity.setStatus(1);
            }
            return imageSpaceService.updateImageSpace(entity);
        } catch (Exception e) {
            throw new BusinessException(ApiCodeEnum.SYSTEM_ERROR, e.getMessage());
        }
    }

    @Override
    public PageResult<ImageSpaceVO> obtainPageableImageSpaceList(ImageSpacePageableDTO pageableDTO) throws BusinessException {
        return imageSpaceService.getPageableImageSpaceList(pageableDTO);
    }

    @Override
    public ImageSpaceVO obtainImageSpace(long imageId) throws BusinessException {
        ImageSpace entity = imageSpaceService.getImageSpaceById(imageId);
        return BeanCopyUtils.copy(entity, ImageSpaceVO.class);
    }
}
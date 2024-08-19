package com.group.consult.commerce.service;

import com.group.consult.commerce.exception.BusinessException;
import com.group.consult.commerce.model.PageResult;
import com.group.consult.commerce.model.dto.*;
import com.group.consult.commerce.model.vo.ImageSpaceVO;
import com.group.consult.commerce.model.vo.NoticeVO;

/**
 * 系统领域模型相关接口
 *
 * @author huangbo
 * @since 2024/08/19
 */
public interface IGlobalDomainService {

    /**
     * 新增图像空间
     *
     * @param imageSpaceAdditionDTO ImageSpaceAdditionDTO
     * @return boolean
     * @throws BusinessException BusinessException
     */
    boolean addImageSpaceInfo(ImageSpaceAdditionDTO imageSpaceAdditionDTO) throws BusinessException;

    /**
     * 根据图像空间ID修改图像空间
     *
     * @param imageSpaceEditionDTO ImageSpaceEditionDTO
     * @return boolean
     * @throws BusinessException BusinessException
     */
    boolean editImageSpaceById(ImageSpaceEditionDTO imageSpaceEditionDTO) throws BusinessException;


    /**
     * 根据图像空间ID删除图像空间
     *
     * @param imageId imageId
     * @return boolean
     * @throws BusinessException BusinessException
     */
    boolean deleteImageSpaceById(long imageId) throws BusinessException;

    /**
     * 根据图像空间ID更改图像空间状态
     *
     * @param imageId imageId
     * @return boolean
     * @throws BusinessException BusinessException
     */
    boolean ableMerchandiseById(long imageId) throws BusinessException;

    /**
     * 获取图像空间(分页)列表
     *
     * @param pageableDTO ImageSpacePageableDTO
     * @return PageResult<ImageSpaceVO>
     * @throws BusinessException BusinessException
     * @author Huang, Dylan Bo
     */
    PageResult<ImageSpaceVO> obtainPageableImageSpaceList(ImageSpacePageableDTO pageableDTO) throws BusinessException;

    /**
     * 根据图像空间ID获取图像空间
     *
     * @param imageId imageId
     * @return ImageSpaceVO
     * @throws BusinessException BusinessException
     */
    ImageSpaceVO obtainImageSpace(long imageId) throws BusinessException;

}

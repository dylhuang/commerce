package com.group.consult.commerce.persist;

import com.baomidou.mybatisplus.extension.service.IService;
import com.group.consult.commerce.dao.entity.ImageSpace;
import com.group.consult.commerce.dao.entity.Notice;
import com.group.consult.commerce.exception.BusinessException;
import com.group.consult.commerce.model.PageResult;
import com.group.consult.commerce.model.dto.ImageSpacePageableDTO;
import com.group.consult.commerce.model.vo.ImageSpaceVO;

/**
 * 图像空间 服务类
 *
 * @author Huang, Dylan Bo
 * @since 2024/08/19
 */
public interface IImageSpaceService extends IService<ImageSpace> {

    /**
     * 新增图像空间
     *
     * @param imageSpace ImageSpace
     * @return boolean
     * @throws BusinessException BusinessException
     */
    boolean insertImageSpace(ImageSpace imageSpace) throws BusinessException;

    /**
     * 修改图像空间
     *
     * @param imageSpace ImageSpace
     * @return boolean
     * @throws BusinessException BusinessException
     */
    boolean updateImageSpace(ImageSpace imageSpace) throws BusinessException;


    /**
     * 根据图像空间ID获取图像空间
     *
     * @param imageId long
     * @return boolean
     * @throws BusinessException BusinessException
     */
    ImageSpace getImageSpaceById(long imageId) throws BusinessException;

    /**
     * 根据图像空间ID获取图像空间【一定包含有图像空间】
     *
     * @param imageId long
     * @return boolean
     * @throws BusinessException BusinessException
     */
    ImageSpace getImageSpaceByIdNotNull(long imageId) throws BusinessException;

    /**
     * 获取图像空间列表分页信息
     *
     * @param pageableDTO NoticePageableDTO
     * @return PageResult<ImageSpaceVO>
     * @throws BusinessException BusinessException
     */
    PageResult<ImageSpaceVO> getPageableImageSpaceList(ImageSpacePageableDTO pageableDTO) throws BusinessException;

}

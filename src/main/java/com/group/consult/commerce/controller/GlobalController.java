package com.group.consult.commerce.controller;

import com.group.consult.commerce.exception.BusinessException;
import com.group.consult.commerce.model.ApiResult;
import com.group.consult.commerce.model.PageResult;
import com.group.consult.commerce.model.dto.ImageSpaceAdditionDTO;
import com.group.consult.commerce.model.dto.ImageSpaceEditionDTO;
import com.group.consult.commerce.model.dto.ImageSpacePageableDTO;
import com.group.consult.commerce.model.vo.ImageSpaceVO;
import com.group.consult.commerce.service.IGlobalDomainService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * 图像空间 前端控制器
 *
 * @author Huang, Dylan Bo
 * @since 2024/08/19
 */
@RestController
@RequestMapping("/api/sys/global")
public class GlobalController {

    @Autowired
    IGlobalDomainService globalDomainService;

    /**
     * 新增全局图像
     *
     * @param imageSpaceAdditionDTO ImageSpaceAdditionDTO
     * @return Boolean
     */
    @PostMapping("/addImage")
    @Operation(summary = "新增全局图像", description = "新增全局图像")
    public ApiResult<Boolean> addImage(@RequestBody ImageSpaceAdditionDTO imageSpaceAdditionDTO) {
        try {
            boolean flag = globalDomainService.addImageSpaceInfo(imageSpaceAdditionDTO);
            return ApiResult.success(flag);
        } catch (BusinessException e) {
            return ApiResult.fail();
        }
    }

    /**
     * 新增全局图像并返回OSS存储的URL地址
     *
     * @param file MultipartFile
     * @return ApiResult<String>
     */
    @PostMapping("/addImageToCloud")
    @Operation(summary = "新增全局图像到云", description = "新增全局图像到云")
    public ApiResult<String> addImageToCloud(@RequestParam(value = "file") MultipartFile file) {
        try {
            String ossUrl = globalDomainService.addImageToOss(file);
            return ApiResult.success(ossUrl);
        } catch (BusinessException e) {
            return ApiResult.fail();
        }
    }

    /**
     * 修改全局图像
     *
     * @param imageSpaceEditionDTO ImageSpaceEditionDTO
     * @return Boolean
     */
    @PostMapping("/editImage")
    @Operation(summary = "修改全局图像", description = "修改全局图像")
    public ApiResult<Boolean> editImage(@RequestBody ImageSpaceEditionDTO imageSpaceEditionDTO) {
        try {
            boolean flag = globalDomainService.editImageSpaceById(imageSpaceEditionDTO);
            return ApiResult.success(flag);
        } catch (BusinessException e) {
            return ApiResult.fail();
        }
    }

    /**
     * 根据全局图像ID删除全局图像
     *
     * @param imageId imageId
     * @return ApiResult<Boolean>
     */
    @GetMapping("/deleteImage")
    @Operation(summary = "根据全局图像ID删除全局图像", description = "根据全局图像ID删除全局图像")
    public ApiResult<Boolean> deleteImage(long imageId) {

        try {
            boolean flag = globalDomainService.deleteImageSpaceById(imageId);
            return ApiResult.success(flag);
        } catch (BusinessException e) {
            return ApiResult.fail();
        }
    }

    /**
     * 根据图像空间ID更改图像空间状态
     *
     * @param imageId imageId
     * @return ApiResult<Boolean>
     */
    @GetMapping("/ableImage")
    @Operation(summary = "根据图像空间ID更改图像空间状态：使可用/使不可用", description = "根据图像空间ID更改图像空间状态：使可用/使不可用")
    public ApiResult<Boolean> ableImage(long imageId) {
        try {
            boolean flag = globalDomainService.ableMerchandiseById(imageId);
            return ApiResult.success(flag);
        } catch (BusinessException e) {
            return ApiResult.fail();
        }
    }

    /**
     * 获取系统公告（分页）列表
     *
     * @param pageableDTO PageableDTO
     * @return List<ApplicationListVO>
     * @author Huang, Dylan Bo
     */
    @PostMapping("/fetchImageList")
    @Operation(summary = "获取图像空间（分页）列表", description = "图像空间分页列表")
    public ApiResult<PageResult<ImageSpaceVO>> fetchImageList(@RequestBody ImageSpacePageableDTO pageableDTO) {
        try {
            PageResult<ImageSpaceVO> result = globalDomainService.obtainPageableImageSpaceList(pageableDTO);
            return ApiResult.success(result);
        } catch (BusinessException e) {
            return ApiResult.fail();
        }
    }

    /**
     * 根据图像空间ID查询图像空间
     *
     * @param imageId imageId
     * @return ApiResult<Boolean>
     */
    @GetMapping("/fetchImage")
    @Operation(summary = "根据图像空间ID查询图像空间", description = "根据图像空间ID查询图像空间")
    public ApiResult<ImageSpaceVO> fetchImage(long imageId) {
        try {
            ImageSpaceVO imageSpaceVO = globalDomainService.obtainImageSpace(imageId);
            return ApiResult.success(imageSpaceVO);
        } catch (BusinessException e) {
            return ApiResult.fail();
        }
    }
}

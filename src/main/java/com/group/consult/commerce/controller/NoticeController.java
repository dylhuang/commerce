package com.group.consult.commerce.controller;

import com.group.consult.commerce.exception.BusinessException;
import com.group.consult.commerce.model.ApiResult;
import com.group.consult.commerce.model.PageResult;
import com.group.consult.commerce.model.dto.NoticeAdditionDTO;
import com.group.consult.commerce.model.dto.NoticeEditionDTO;
import com.group.consult.commerce.model.dto.NoticePageableDTO;
import com.group.consult.commerce.model.vo.NoticeVO;
import com.group.consult.commerce.service.INoticeDomainService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 系统公告 前端控制器
 *
 * @author Huang, Dylan Bo
 * @since 2024/08/13
 */
@RestController
@RequestMapping("/api/sys/notice")
public class NoticeController {

    @Autowired
    private INoticeDomainService noticeDomainService;

    /**
     * 新增系统公告
     *
     * @param noticeAdditionDTO NoticeAdditionDTO
     * @return Boolean
     */
    @PostMapping("/addNotice")
    @Operation(summary = "新增系统公告", description = "新增系统公告")
    public ApiResult<Boolean> addNotice(@RequestBody NoticeAdditionDTO noticeAdditionDTO) {
        try {
            boolean flag = noticeDomainService.addNoticeInfo(noticeAdditionDTO);
            return ApiResult.success(flag);
        } catch (BusinessException e) {
            return ApiResult.fail();
        }
    }

    /**
     * 修改系统公告
     *
     * @param noticeEditionDTO NoticeEditionDTO
     * @return Boolean
     */
    @PostMapping("/editNotice")
    @Operation(summary = "修改系统公告", description = "修改系统公告")
    public ApiResult<Boolean> editNotice(@RequestBody NoticeEditionDTO noticeEditionDTO) {
        try {
            boolean flag = noticeDomainService.editNoticeById(noticeEditionDTO);
            return ApiResult.success(flag);
        } catch (BusinessException e) {
            return ApiResult.fail();
        }
    }

    /**
     * 根据系统公告ID删除系统公告
     *
     * @param noticeId noticeId
     * @return ApiResult<Boolean>
     */
    @GetMapping("/deleteNotice")
    @Operation(summary = "根据系统公告ID删除系统公告", description = "根据系统公告ID删除系统公告")
    public ApiResult<Boolean> deleteNotice(long noticeId) {
        try {
            boolean flag = noticeDomainService.deleteNoticeById(noticeId);
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
    @PostMapping("/fetchMerchandiseList")
    @Operation(summary = "获取系统公告（分页）列表", description = "分页系统公告分页列表")
    public ApiResult<PageResult<NoticeVO>> fetchMerchandiseList(@RequestBody NoticePageableDTO pageableDTO) {
        try {
            PageResult<NoticeVO> result = noticeDomainService.obtainPageableNoticeList(pageableDTO);
            return ApiResult.success(result);
        } catch (BusinessException e) {
            return ApiResult.fail();
        }
    }

    /**
     * 根据系统公告ID查询系统公告详情
     *
     * @param noticeId noticeId
     * @return ApiResult<Boolean>
     */
    @GetMapping("/fetchNotice")
    @Operation(summary = "根据系统公告ID查询系统公告详情", description = "根据系统公告ID查询系统公告详情")
    public ApiResult<NoticeVO> fetchNotice(long noticeId) {
        try {
            NoticeVO noticeVO = noticeDomainService.obtainNotice(noticeId);
            return ApiResult.success(noticeVO);
        } catch (BusinessException e) {
            return ApiResult.fail();
        }
    }
}

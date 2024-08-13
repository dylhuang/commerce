package com.group.consult.commerce.service;

import com.group.consult.commerce.exception.BusinessException;
import com.group.consult.commerce.model.PageResult;
import com.group.consult.commerce.model.dto.NoticeAdditionDTO;
import com.group.consult.commerce.model.dto.NoticeEditionDTO;
import com.group.consult.commerce.model.dto.NoticePageableDTO;
import com.group.consult.commerce.model.vo.NoticeVO;

/**
 * 商品领域模型相关接口
 *
 * @author huangbo
 * @since 2024/08/08
 */
public interface INoticeDomainService {

    /**
     * 新增系统公告
     *
     * @param noticeAdditionDTO NoticeAdditionDTO
     * @return boolean
     * @throws BusinessException BusinessException
     */
    boolean addNoticeInfo(NoticeAdditionDTO noticeAdditionDTO) throws BusinessException;

    /**
     * 根据系统公告ID修改系统公告
     *
     * @param noticeEditionDTO NoticeEditionDTO
     * @return boolean
     * @throws BusinessException BusinessException
     */
    boolean editNoticeById(NoticeEditionDTO noticeEditionDTO) throws BusinessException;


    /**
     * 根据系统公告ID删除系统公告
     *
     * @param noticeId noticeId
     * @return boolean
     * @throws BusinessException BusinessException
     */
    boolean deleteNoticeById(long noticeId) throws BusinessException;

    /**
     * 获取系统公告(分页)列表
     *
     * @param pageableDTO NoticePageableDTO
     * @return PageResult<NoticeVO>
     * @throws BusinessException BusinessException
     * @author Huang, Dylan Bo
     */
    PageResult<NoticeVO> obtainPageableNoticeList(NoticePageableDTO pageableDTO) throws BusinessException;

    /**
     * 根据系统公告ID获取系统公告详情
     *
     * @param noticeId long
     * @return NoticeVO
     * @throws BusinessException BusinessException
     */
    NoticeVO obtainNotice(long noticeId) throws BusinessException;

}

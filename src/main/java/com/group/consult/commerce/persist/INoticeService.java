package com.group.consult.commerce.persist;

import com.baomidou.mybatisplus.extension.service.IService;
import com.group.consult.commerce.dao.entity.Notice;
import com.group.consult.commerce.exception.BusinessException;
import com.group.consult.commerce.model.PageResult;
import com.group.consult.commerce.model.dto.NoticePageableDTO;
import com.group.consult.commerce.model.vo.NoticeVO;

/**
 * 系统公告 服务类
 *
 * @author Huang, Dylan Bo
 * @since 2024/08/13
 */
public interface INoticeService extends IService<Notice> {

    /**
     * 新增系统公告
     *
     * @param notice Notice
     * @return boolean
     * @throws BusinessException BusinessException
     */
    boolean insertNotice(Notice notice) throws BusinessException;

    /**
     * 修改系统公告
     *
     * @param notice Notice
     * @return boolean
     * @throws BusinessException BusinessException
     */
    boolean updateMerchandise(Notice notice) throws BusinessException;


    /**
     * 根据系统公告ID获取系统公告
     *
     * @param noticeId long
     * @return boolean
     * @throws BusinessException BusinessException
     */
    Notice getNoticeById(long noticeId) throws BusinessException;

    /**
     * 根据系统公告ID获取系统公告【一定包含有系统公告】
     *
     * @param noticeId long
     * @return boolean
     * @throws BusinessException BusinessException
     */
    Notice getNoticeByIdNotNull(long noticeId) throws BusinessException;

    /**
     * 获取系统公告列表分页信息
     *
     * @param pageableDTO NoticePageableDTO
     * @return PageResult<NoticeVO>
     * @throws BusinessException BusinessException
     */
    PageResult<NoticeVO> getPageableNoticeList(NoticePageableDTO pageableDTO) throws BusinessException;

}

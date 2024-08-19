package com.group.consult.commerce.persist.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.group.consult.commerce.dao.entity.Notice;
import com.group.consult.commerce.dao.mapper.NoticeMapper;
import com.group.consult.commerce.exception.BusinessException;
import com.group.consult.commerce.model.ApiCodeEnum;
import com.group.consult.commerce.model.PageResult;
import com.group.consult.commerce.model.dto.NoticePageableDTO;
import com.group.consult.commerce.model.vo.NoticeVO;
import com.group.consult.commerce.persist.INoticeService;
import com.group.consult.commerce.utils.SqlUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * <p>
 * 系统公告 服务实现类
 * </p>
 *
 * @author Huang, Dylan Bo
 * @since 2024/08/13
 */
@Service
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, Notice> implements INoticeService {

    @Override
    public boolean insertNotice(Notice notice) throws BusinessException {
        try {
            return this.saveOrUpdate(notice);
        } catch (Exception e) {
            throw new BusinessException(ApiCodeEnum.SYSTEM_ERROR, e.getMessage());
        }
    }

    @Override
    public boolean updateMerchandise(Notice notice) throws BusinessException {
        try {
            return this.updateById(notice);
        } catch (Exception e) {
            throw new BusinessException(ApiCodeEnum.SYSTEM_ERROR, e.getMessage());
        }
    }

    @Override
    public Notice getNoticeById(long noticeId) throws BusinessException {
        try {
            return this.getById(noticeId);
        } catch (Exception e) {
            throw new BusinessException(ApiCodeEnum.SYSTEM_ERROR, e.getMessage());
        }
    }

    @Override
    public Notice getNoticeByIdNotNull(long noticeId) throws BusinessException {
        Notice entity = this.getNoticeById(noticeId);
        if (null == entity) {
            throw new BusinessException(ApiCodeEnum.NOTICE_QUERY_NOT_NULL);
        }
        return entity;
    }

    @Override
    public PageResult<NoticeVO> getPageableNoticeList(NoticePageableDTO pageableDTO) throws BusinessException {
        try {
            pageableDTO.initWithUpdateTimeSort();
            LambdaQueryWrapper<Notice> wrapper = Wrappers.lambdaQuery();
            Optional.ofNullable(pageableDTO.getTitle())
                    .filter(StringUtils::isNotEmpty)
                    .ifPresent(o -> wrapper.like(Notice::getTitle, o));
            SqlUtils.commonOrderBy(pageableDTO.getSorts(), wrapper);
            Page<Notice> page = this.page(Page.of(pageableDTO.getPageNum(), pageableDTO.getPageSize()), wrapper);
            List<NoticeVO> resultList = page.getRecords().stream().map(NoticeVO::of).collect(Collectors.toList());
            return PageResult.of(resultList, page);
        } catch (Exception e) {
            throw new BusinessException(ApiCodeEnum.SYSTEM_ERROR, e.getMessage());
        }
    }
}

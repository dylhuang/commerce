package com.group.consult.commerce.service.impl;

import com.group.consult.commerce.dao.entity.Notice;
import com.group.consult.commerce.exception.BusinessException;
import com.group.consult.commerce.model.ApiCodeEnum;
import com.group.consult.commerce.model.PageResult;
import com.group.consult.commerce.model.dto.NoticeAdditionDTO;
import com.group.consult.commerce.model.dto.NoticeEditionDTO;
import com.group.consult.commerce.model.dto.NoticePageableDTO;
import com.group.consult.commerce.model.vo.NoticeVO;
import com.group.consult.commerce.persist.INoticeService;
import com.group.consult.commerce.service.INoticeDomainService;
import com.group.consult.commerce.utils.BeanCopyUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class NoticeDomainServiceImpl implements INoticeDomainService {

    @Autowired
    private INoticeService noticeService;

    @Override
    public boolean addNoticeInfo(NoticeAdditionDTO noticeAdditionDTO) throws BusinessException {
        Notice notice = BeanCopyUtils.copy(noticeAdditionDTO, Notice.class);
        return noticeService.insertNotice(notice);
    }

    @Override
    public boolean editNoticeById(NoticeEditionDTO noticeEditionDTO) throws BusinessException {
        Long noticeId = noticeEditionDTO.getNoticeId();
        Notice entity = noticeService.getNoticeByIdNotNull(noticeId);
        entity.setTitle(noticeEditionDTO.getTitle());
        entity.setSummary(noticeEditionDTO.getSummary());
        entity.setContent(noticeEditionDTO.getContent());
        entity.setPopup(noticeEditionDTO.getPopup());
        return noticeService.updateMerchandise(entity);
    }

    @Override
    public boolean deleteNoticeById(long noticeId) throws BusinessException {
        noticeService.getNoticeByIdNotNull(noticeId);
        try {
            return noticeService.removeById(noticeId);
        } catch (Exception e) {
            throw new BusinessException(ApiCodeEnum.SYSTEM_ERROR, e.getMessage());
        }
    }

    @Override
    public PageResult<NoticeVO> obtainPageableNoticeList(NoticePageableDTO pageableDTO) throws BusinessException {
        return noticeService.getPageableNoticeList(pageableDTO);
    }

    @Override
    public NoticeVO obtainNotice(long noticeId) throws BusinessException {
        Notice entity = noticeService.getNoticeById(noticeId);
        return BeanCopyUtils.copy(entity, NoticeVO.class);
    }
}
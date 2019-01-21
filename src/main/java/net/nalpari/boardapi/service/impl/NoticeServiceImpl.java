package net.nalpari.boardapi.service.impl;

import net.nalpari.boardapi.entity.Notice;
import net.nalpari.boardapi.repository.NoticeRepository;
import net.nalpari.boardapi.service.NoticeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {

    private static final Logger logger = LoggerFactory.getLogger(NoticeServiceImpl.class);

    private final NoticeRepository noticeRepository;

    @Autowired
    public NoticeServiceImpl(NoticeRepository noticeRepository) {
        this.noticeRepository = noticeRepository;
    }

    @Override
    public List<Notice> getNoticeList() throws Exception {
        return noticeRepository.findAllByOrderByIdDesc();
    }

    @Override
    public void save(Notice notice) {
        noticeRepository.save(notice);
    }

    @Override
    public void update(Notice notice) {
        logger.debug("################## id: {}", notice.getId());
        Notice param = noticeRepository.getOne(notice.getId());
        param.setTitle(notice.getTitle());
        param.setContents(notice.getContents());
        noticeRepository.save(notice);
    }

    @Override
    public void delete(long id) {
        try {
            noticeRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

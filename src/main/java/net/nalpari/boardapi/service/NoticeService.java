package net.nalpari.boardapi.service;

import net.nalpari.boardapi.entity.Notice;
import java.util.List;

public interface NoticeService {
    public List<Notice> getNoticeList() throws Exception;
    public void save(Notice notice);
    public void update(Notice notice);
    public void delete(long id);
}

package net.nalpari.boardapi.controller;

import net.nalpari.boardapi.entity.Notice;
import net.nalpari.boardapi.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notice")
public class NoticeController {

    private final NoticeService noticeService;

    @Autowired
    public NoticeController(NoticeService noticeService) {
        this.noticeService = noticeService;
    }

    @GetMapping("/list")
    public List<Notice> list() throws Exception{

        return noticeService.getNoticeList();
    }

    @PostMapping("/regist")
    public void regist(Notice notice) {
        noticeService.save(notice);
    }

    @PutMapping("/update")
    public void update(Notice notice) {
        noticeService.update(notice);
    }

    @DeleteMapping("/delete")
    public void delete(long id) {
        noticeService.delete(id);
    }
}

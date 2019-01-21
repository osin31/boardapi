package net.nalpari.boardapi.repository;

import net.nalpari.boardapi.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticeRepository extends JpaRepository<Notice,Long> {
    public Notice findById(long id)throws Exception;
    public List<Notice> findAllByOrderByIdDesc() throws Exception;
    public void deleteById(long id) throws Exception;
}

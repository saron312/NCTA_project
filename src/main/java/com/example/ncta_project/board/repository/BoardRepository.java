package com.example.ncta_project.board.repository;

import com.example.ncta_project.board.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface BoardRepository extends JpaRepository<Board, Long> {

    Page<Board> findByCertificateContaining(String searchKeyword, Pageable pageable);
    Page<Board> findByTitleContaining(String searchKeyword, Pageable pageable);

    @Transactional
    @Modifying
    @Query(value = "update board b set b.view_count = b.view_count + 1 where b.bId = :bId" ,nativeQuery = true)
    void ViewCount(Long bId);
}

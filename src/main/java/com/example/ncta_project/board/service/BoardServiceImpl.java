package com.example.ncta_project.board.service;

import com.example.ncta_project.board.Board;
import com.example.ncta_project.board.repository.BoardRepository;
import com.example.ncta_project.comment.repository.CommentRepository;
import com.example.ncta_project.exception.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private BoardRepository boardRepository;

    private CommentRepository commentRepository;

    @Override
    public Page<Board> getBoardList(Pageable pageable) {
        Page<Board> boards = boardRepository.findAll(pageable);
        return boards;
    }

    @Override
    public void deleteBoard(Long bId) {
        boardRepository.deleteById(bId);
    }

    @Override
    public Page<Board> searchBoardList(String selectKeyword ,String searchKeyword, Pageable pageable) {
        Page<Board> boards = null;
        if(selectKeyword.equals("certificate")){
            boards = boardRepository.findByCertificateContaining(searchKeyword, pageable);
        }else if(selectKeyword.equals("title")){
            boards = boardRepository.findByTitleContaining(searchKeyword, pageable);
        }
        return boards;
    }

//    @Override
//    public void insertBoard(String id, String title, String content) {
//        Board board = Board.builder().id(id).title(title).content(content).build();
//        boardRepository.save(board);
//    }

    @Override
    public Board getBoard(Long bId) {
        Optional<Board> board = this.boardRepository.findById(bId);
        if(board.isPresent()) {
            return board.get();
        } else {
            throw new DataNotFoundException("데이터가 없습니다.");
        }
    }

    @Override
    public void insertBoardList(String id, String title, String content, String certificate) {
        Board b = new Board();
        b.setId(id);
        b.setCertificate(certificate);
        b.setTitle(title);
        b.setContent(content);
        b.setCreateDate(LocalDateTime.now());
        this.boardRepository.save(b);
    }
    @Override
    public void writeComment(Board board, String comment) {
//        Comment c1 = new Comment();
//        c1.setComment(comment);
//        c1.setCreateDate(LocalDateTime.now());
//        c1.setBoard(board);
//        this.commentRepository.save(c1);
    }



    @Transactional
    @Override
    public void updateViewCount(Long bId) {
        boardRepository.ViewCount(bId);
    }
}


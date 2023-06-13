package com.example.ncta_project.board.service;

import com.example.ncta_project.board.Board;
import com.example.ncta_project.board.dto.BoardDTO;
import com.example.ncta_project.board.dto.InsertDTO;
import com.example.ncta_project.board.dto.PostsDTO;
import com.example.ncta_project.board.dto.SmartEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;


public interface BoardService {
    Page<BoardDTO> getBoardList(int PageNum);

    Long countTodayPosts();
    void viewCountPlus(Long bId);
//    Page<Board> searchBoardList(String selectKeyword, String searchKeyword, Pageable pageable);
//    //    void insertBoard(String id, String title, String content);
//    void deleteBoard(Long bId);
//    Board getBoard(Long bId);
//    void insertBoardList(String id, String title, String content, String certificate);
//    void writeComment(Board board, String comment);
//
//    void updateViewCount(Long bId);
    void insertBoard(String memberId,InsertDTO insertDTO);

    PostsDTO loadPosts(Long bId);

}

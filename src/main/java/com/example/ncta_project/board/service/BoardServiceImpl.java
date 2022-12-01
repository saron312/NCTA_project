package com.example.ncta_project.board.service;

import com.example.ncta_project.board.Board;
import com.example.ncta_project.board.dto.BoardDTO;
import com.example.ncta_project.board.dto.InsertDTO;
import com.example.ncta_project.board.dto.PostsDTO;
import com.example.ncta_project.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    //    private CommentRepository commentRepository;
//
    @Override
    public Page<BoardDTO> getBoardList(int pageNum) {
        Pageable pageable = PageRequest.of(pageNum, 10, Sort.by("bId").descending());
        return boardRepository.findAll(pageable).map(board -> BoardDTO.fromEntity(board,dateFormat(board)));
    }
    @Override
    public Long countTodayPosts() {
        return boardRepository.countTodayPosts();
    }

    public String dateFormat(Board board){
        if (board.getModifiedAt().toLocalDate().isBefore(LocalDate.now())) {
            return board.getModifiedAt().format(DateTimeFormatter.ofPattern("yy.MM.dd"));
        } else {
            return board.getModifiedAt().format(DateTimeFormatter.ofPattern("HH:mm"));
        }
    }

    @Override
    public void insertBoard(String memberId, InsertDTO insertDTO) {
        boardRepository.save(insertDTO.toEntity(memberId));
    }

    @Override
    public PostsDTO loadPosts(Long bId) {
        return PostsDTO.fromEntity(boardRepository.findById(bId)
                .orElseThrow(()-> new NullPointerException(bId +"-> 데이터베이스에서 찾을 수 없습니다.")));
    }

//    @Override
//    public void deleteBoard(Long bId) {
//        boardRepository.deleteById(bId);
//    }
//
//    @Override
//    public Page<Board> searchBoardList(String selectKeyword ,String searchKeyword, Pageable pageable) {
//        Page<Board> boards = null;
//        if(selectKeyword.equals("certificate")){
//            boards = boardRepository.findByCertificateContaining(searchKeyword, pageable);
//        }else if(selectKeyword.equals("title")){
//            boards = boardRepository.findByTitleContaining(searchKeyword, pageable);
//        }
//        return boards;
//    }
//
////    @Override
////    public void insertBoard(String id, String title, String content) {
////        Board board = Board.builder().id(id).title(title).content(content).build();
////        boardRepository.save(board);
////    }
//
//    @Override
//    public Board getBoard(Long bId) {
//        Optional<Board> board = this.boardRepository.findById(bId);
//        if(board.isPresent()) {
//            return board.get();
//        } else {
//            throw new DataNotFoundException("데이터가 없습니다.");
//        }
//    }
//
//    @Override
//    public void insertBoardList(String id, String title, String content, String certificate) {
//        Board b = new Board();
//        b.setId(id);
//        b.setSubject(certificate);
//        b.setTitle(title);
//        b.setContent(content);
//        b.setCreateDate(LocalDateTime.now());
//        this.boardRepository.save(b);
//    }
//    @Override
//    public void writeComment(Board board, String comment) {
////        Comment c1 = new Comment();
////        c1.setComment(comment);
////        c1.setCreateDate(LocalDateTime.now());
////        c1.setBoard(board);
////        this.commentRepository.save(c1);
//    }
//
//    @Transactional
//    @Override
//    public void updateViewCount(Long bId) {
//        boardRepository.ViewCount(bId);
//    }
}


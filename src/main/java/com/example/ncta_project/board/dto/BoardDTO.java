package com.example.ncta_project.board.dto;

import com.example.ncta_project.board.Board;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Data
@Builder
public class BoardDTO {
    private long bId;

    private String title;

//    private String content;

    private String subject;

    private int viewCount;

    private String modifiedAt;

    private String writer;

    private int commentListSize;

    public static BoardDTO fromEntity(Board board,String modifiedAt) {
        return BoardDTO.builder()
                .bId(board.getBId())
                .title(board.getTitle())
                .subject(board.getSubject())
                .viewCount(board.getViewCount())
                .modifiedAt(modifiedAt)
                .writer(board.getMember().getMemberId())
                .commentListSize(board.getCommentList().size())
                .build();
    }
}

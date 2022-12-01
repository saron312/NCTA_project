package com.example.ncta_project.board.dto;

import com.example.ncta_project.board.Board;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class PostsDTO {

    private long bId;

    private String title;

    private String content;

    private String subject;

    private int viewCount;

    private LocalDateTime modifiedAt;

    private String writer;

    public static PostsDTO fromEntity(Board board) {
        return PostsDTO.builder()
                .bId(board.getBId())
                .title(board.getTitle())
                .subject(board.getSubject())
                .content(board.getContent())
                .viewCount(board.getViewCount())
                .modifiedAt(board.getModifiedAt())
                .writer(board.getMember().getMemberId())
                .build();
    }
}

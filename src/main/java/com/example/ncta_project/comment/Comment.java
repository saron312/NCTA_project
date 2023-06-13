package com.example.ncta_project.comment;


import com.example.ncta_project.board.BaseTime;
import com.example.ncta_project.board.Board;
import com.example.ncta_project.member.Member;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Comment extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cId;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String comment;

    @Column(nullable = false)
    private boolean secret;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String img;

    @ManyToOne
    private Board board;

    @ManyToOne
    private Member member;
}

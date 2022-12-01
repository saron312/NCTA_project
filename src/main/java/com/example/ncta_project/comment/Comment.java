package com.example.ncta_project.comment;


import com.example.ncta_project.board.Board;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cId;

    @Column(nullable = false)
    private String comment;

    private LocalDateTime createDate;

    @ManyToOne
    private Board board;
}

package com.example.ncta_project.board;


import com.example.ncta_project.comment.Comment;
import com.example.ncta_project.member.Member;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Board extends BaseTime{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bId;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Column(nullable = false)
    private String subject;

    @OneToMany(mappedBy = "board", cascade = CascadeType.REMOVE)
    // 질문 하나에 여러개 답변이 작성될 수 있는데 질문을 삭제하면 그에 달린 답변들도 모두 함께 삭제하기 위해 Remove 사용
    private List<Comment> commentList;

    @Column(columnDefinition = "integer default 0", nullable = false)
    private int viewCount;

    @ManyToOne
    private Member member;

}

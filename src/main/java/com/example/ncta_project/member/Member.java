package com.example.ncta_project.member;

import com.example.ncta_project.board.Board;
import com.example.ncta_project.comment.Comment;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Member {

    @Id
    private String memberId;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @OneToMany(mappedBy = "member", cascade = CascadeType.REMOVE)
    // 질문 하나에 여러개 답변이 작성될 수 있는데 질문을 삭제하면 그에 달린 답변들도 모두 함께 삭제하기 위해 Remove 사용
    private List<Board> boardList;

    @OneToMany(mappedBy = "member", cascade = CascadeType.REMOVE)
    private List<Comment> commentList;


}

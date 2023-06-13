package com.example.ncta_project.comment.controller;

import com.example.ncta_project.comment.dto.CommentDTO;
import com.example.ncta_project.comment.dto.CommentInsertDTO;
import com.example.ncta_project.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentRestController {

    private final CommentService commentService;

    @PostMapping("/list")
    public List<CommentDTO> commentList(@RequestParam Long bId){
        return commentService.getCommentList(bId);
    }

    @PostMapping("/write")
    public void write(Principal principal, @RequestBody CommentInsertDTO commentInsertDTO){
        commentService.insertComment(principal.getName(),commentInsertDTO);
    }
}

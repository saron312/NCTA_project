package com.example.ncta_project.board.controller;

import com.example.ncta_project.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@RequiredArgsConstructor
@Controller
@RequestMapping("/community")
public class BoardController {

    private final BoardService boardService;

    @GetMapping
    public String boardPage(Model model) {
       // model.addAttribute("todayPosts",boardService.countTodayPosts());
        //amodel.addAttribute("board",boardService.getBoardList(0));
        return "communityMain";
    }

    @PostMapping
    public String community(int pageNum,Model model){
        model.addAttribute("countTodayPosts",boardService.countTodayPosts());
        model.addAttribute("board", boardService.getBoardList(pageNum-1));
        return "communityMain";
    }

    @GetMapping("/write")
    public String writeForm() {
        return "communityWrite";
    }

    @GetMapping("/{bId}")
    public String posts(@PathVariable("bId") Long bId,Model model){
        boardService.viewCountPlus(bId);
        model.addAttribute("posts",boardService.loadPosts(bId));
        return "communityPosts";
    }


}

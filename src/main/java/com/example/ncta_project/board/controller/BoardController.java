package com.example.ncta_project.board.controller;

import com.example.ncta_project.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@SessionAttributes("memberId")
@RequiredArgsConstructor
@Controller
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/community")
    public String boardPage(){
//
//        Page<Board> boardList= null;
//
//        boardList = boardService.getBoardList(pageable);
//
//        int nowPage= boardList.getPageable().getPageNumber();
//
//        int startPage=Math.max(nowPage -4,1);
//        int endPage=Math.min(nowPage+5,boardList.getTotalPages());
//        int previous = nowPage-1;
//        int next = nowPage+1;
//
//        String checkedSearch = "false";
//        model.addAttribute("checkedSearch", checkedSearch);
//
//        model.addAttribute("memberId", memberId);
//
//        model.addAttribute("boardList", boardList);
//        model.addAttribute("nowPage", nowPage);
//        model.addAttribute("startPage", startPage);
//        model.addAttribute("endPage", endPage);
//        model.addAttribute("previous",previous);
//        model.addAttribute("next",next);
//
        return "community";
    }

//    @PostMapping("/boardList")
//    public String searchBoardList(@RequestParam String searchKeyword, @RequestParam String selectKeyword, @PageableDefault(page=0, size = 5, sort = "bId", direction = Sort.Direction.DESC) Pageable pageable
//            , Model model, @ModelAttribute("memberId") String memberId) {
//
//        Page<Board> searchPage = null;
//        searchPage = boardService.searchBoardList(selectKeyword,
//                searchKeyword, pageable);
//
//        int nowPage = searchPage.getPageable().getPageNumber();
//        int startPage = Math.max(nowPage - 4, 1);
//        int endPage = Math.min(nowPage + 5, searchPage.getTotalPages());
//        int previous = nowPage - 1;
//        int next = nowPage + 1;
//
//        String checkedSearch = "true";
//        model.addAttribute("checkedSearch", checkedSearch);
//        model.addAttribute("searchKeyword", searchKeyword);
//        model.addAttribute("selectKeyword", selectKeyword);
//
//        model.addAttribute("memberId", memberId);
//
//        model.addAttribute("boardList", searchPage);
//        model.addAttribute("nowPage", nowPage);
//        model.addAttribute("startPage", startPage);
//        model.addAttribute("endPage", endPage);
//        model.addAttribute("previous", previous);
//        model.addAttribute("next", next);
//
//        return "/boardList";
//    }

//    @GetMapping("/deleteBoard")
//    public String deleteBoardList(@RequestParam Long bId){
//        boardService.deleteBoard(bId);
//        return "redirect:/boardList";
//    }
//
//    @GetMapping("/boardInput")
//    public String boardInputPage(){
//
//        return "/boardInput";
//    }
//
//    @PostMapping("/boardInput")
//    public String boardInput(@ModelAttribute("memberId") String memberId,
//                              @RequestParam String title, @RequestParam String content,
//                              @RequestParam String certificate){
//
//        this.boardService.insertBoardList(memberId, title, content, certificate);
//        return "redirect:/boardList";
//    }
//
//    @RequestMapping(value = "/commentBoard/{bId}")
//    public String commentBoardPage(@ModelAttribute("memberId") String memberId, Model model, @PathVariable("bId") Long bId) {
//        Board board = this.boardService.getBoard(bId);
//        this.boardService.updateViewCount(bId);
//        model.addAttribute("board", board);
//
//        String sessionMemberId = memberId;
//        model.addAttribute("sessionMemberId", sessionMemberId);
//        return "/commentBoard";
//    }
//
//    @PostMapping("/comment/write/{bId}")
//    public String writeComment(@ModelAttribute("memberId") String memberId,Model model, @PathVariable("bId") Long bId, @RequestParam String comment){
//
//        Board board = this.boardService.getBoard(bId);
//        this.boardService.writeComment(board, comment);
//        String sessionMemberId = memberId;
//        model.addAttribute("sessionMemberId", sessionMemberId);
//        return String.format("redirect:/commentBoard/%s", bId);
//    }

    @GetMapping("/communityWrite")
    public String writeForm(){return "communityWrite";}
}

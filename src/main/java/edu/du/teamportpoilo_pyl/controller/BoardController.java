package edu.du.teamportpoilo_pyl.controller;

import edu.du.teamportpoilo_pyl.dto.CommentDto;
import edu.du.teamportpoilo_pyl.service.BoardService;
import edu.du.teamportpoilo_pyl.service.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pyl")
public class BoardController {

    private final BoardService boardService;
    private final CommentService commentService;

    public BoardController(BoardService boardService, CommentService commentService) {
        this.boardService = boardService;
        this.commentService = commentService;
    }

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/list")
    public String boardList(Model model) {
        model.addAttribute("board", boardService.getAllBoards());

        return "boardList";
    }

    @GetMapping("/board/{id}")
    public String viewBoard(@PathVariable Long id, @ModelAttribute CommentDto commentDto, Model model) {
        model.addAttribute("board", boardService.getBoardById(id));
        model.addAttribute("comments", commentService.getAllComments(id));
        return "viewBoard";
    }

    @GetMapping("/board/write")
    public String writeBoard(Model model) {
        return "writeBoard";
    }
}

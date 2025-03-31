package edu.du.teamportpoilo_pyl.controller;

import edu.du.teamportpoilo_pyl.dto.CommentDto;
import edu.du.teamportpoilo_pyl.service.BoardService;
import edu.du.teamportpoilo_pyl.service.CommentService;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class BoardRestController {

    private final BoardService boardService;
    private final CommentService commentService;

    public BoardRestController(BoardService boardService, CommentService commentService) {
        this.boardService = boardService;
        this.commentService = commentService;
    }

    @PostMapping("/api/board/{id}/comment/delete")
    public ResponseEntity<Map<String, Object>> deleteComment(@PathVariable Long id,
                                                             @RequestParam("commentId") Long commentId,
                                                             @RequestParam("commentAuthor") String commentAuthor,
                                                             HttpSession session) {
        Map<String, Object> response = new HashMap<>();
        String nameSession = (String) session.getAttribute("name");

        if (!commentAuthor.equals(nameSession)) {
            response.put("success", false);
            response.put("message", "게시글 삭제 권한이 없습니다.");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
        }

        commentService.deleteComment(commentId);
        return ResponseEntity.ok(response);
    }

}

package edu.du.teamportpoilo_pyl.service;

import edu.du.teamportpoilo_pyl.dto.BoardDto;
import edu.du.teamportpoilo_pyl.mapper.BoardMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    private final BoardMapper boardMapper;

    public BoardService(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }

    public List<BoardDto> getAllBoards() {
        return boardMapper.boardSelectAll();
    }

    public BoardDto getBoardById (Long id) {
        boardMapper.boardViews(id);
        return boardMapper.boardSelectById(id);
    }

    public void insertBoard(BoardDto board) {
       boardMapper.boardInsert(board);
    }

    public void updateBoard(BoardDto board) {
        boardMapper.boardUpdate(board);
    }

    public void deleteBoard(Long id) {
        boardMapper.boardDelete(id);
    }
}

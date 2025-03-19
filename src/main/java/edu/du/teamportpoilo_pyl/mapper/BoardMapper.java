package edu.du.teamportpoilo_pyl.mapper;

import edu.du.teamportpoilo_pyl.dto.BoardDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BoardMapper {

    @Select("select * from board")
    public List<BoardDto> boardSelectAll();

    @Select("select * from board where id = #{id}")
    public BoardDto boardSelectById(Long id);

    @Insert("insert into board (title, content, author, created_at, views, likes) values (#{title}, #{content}, #{author}, now(), 0, 0)")
    public void boardInsert(BoardDto board);

    @Update("update board set title = #{title}, content = #{content}, updated_at = now()")
    public void boardUpdate(BoardDto board);

    @Delete("delete from board where id = #{id}")
    public void boardDelete(Long id);
}

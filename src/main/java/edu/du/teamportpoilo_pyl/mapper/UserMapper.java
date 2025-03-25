package edu.du.teamportpoilo_pyl.mapper;

import edu.du.teamportpoilo_pyl.dto.UserDto;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

    @Select("select * from users where username = #{userId}")
    @Results({
            @Result(property = "userId", column = "username"),
            @Result(property = "created", column = "created_at")
    })
    public UserDto selectByUserId(String username);

    @Insert("insert into users (username, password, name, email) values (#{userId}, #{password}, #{name}, #{email})")
    @Results({
            @Result(property = "userId", column = "username")
    })
    public void insertUser(UserDto user);
}

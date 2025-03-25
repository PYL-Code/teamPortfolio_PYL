package edu.du.teamportpoilo_pyl.service;

import edu.du.teamportpoilo_pyl.dto.UserDto;
import edu.du.teamportpoilo_pyl.mapper.UserMapper;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public UserDto getUserByUserId(String userId) {
        return userMapper.selectByUserId(userId);
    }

    public Boolean userLogin(String UserId, String password, HttpSession session) {
        UserDto userDto = userMapper.selectByUserId(UserId);

        if (userDto == null) {
            return false;
        }
        if (!userDto.getPassword().equals(password)) {
            return false;
        }
        session.setAttribute("userId", userDto.getUserId());
        session.setAttribute("name", userDto.getName());
        return true;
    }

    public void insertUser(UserDto user) {
        userMapper.insertUser(user);
    }
}

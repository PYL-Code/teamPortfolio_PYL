package edu.du.teamportpoilo_pyl.controller;

import edu.du.teamportpoilo_pyl.dto.UserDto;
import edu.du.teamportpoilo_pyl.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String loginForm() {
        return "login/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String userId, @RequestParam String password,
                        HttpSession session,  Model model) {

        if (userService.userLogin(userId, password, session)) {
            return "redirect:/";
        } else {
            model.addAttribute("error", "아이디나 비밀번호가 일치하지 않습니다.");
            return "login/login";
        }
    }

    @GetMapping("signup")
    public String signupForm() {
        return "login/signup";
    }

    @PostMapping("/signup")
    public String signup(@ModelAttribute UserDto user, Model model) {
        userService.insertUser(user);
        return "redirect:/user/login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // 세션 삭제 (로그아웃)
        return "redirect:/user/login";
    }
}

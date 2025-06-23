package com.onnuri.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.onnuri.dto.UserDto;
import com.onnuri.service.UserService;

@Controller
public class UserController {
	@Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping("/")
    public String root() {
        return "user/login"; 
    }
    
    @RequestMapping("/user/signUpForm")
    public String loginForm() {
        return "user/signUpForm"; 
    }

    @RequestMapping("/user/signUpProcess")
    public String signUpProcess(UserDto dto, Model model) {
        // 비밀번호 암호화
        String encodedPassword = passwordEncoder.encode(dto.getUser_passwd());
        dto.setUser_passwd(encodedPassword);
        dto.setUser_authority("user");
        
        int result = userService.insertUser(dto);
        if (result > 0) {
            model.addAttribute("message", "회원가입 성공");
            return "redirect:/";
        } else {
            model.addAttribute("message", "회원가입 실패");
            return "user/signUpForm";
        }
    }
    
    @RequestMapping("/Main")
    public String main() {
        return "main/main"; 
    }
}

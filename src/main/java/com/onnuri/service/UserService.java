package com.onnuri.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.onnuri.dao.UserMapper;
import com.onnuri.dto.CustomUserDetails;
import com.onnuri.dto.UserDto;

@Service
public class UserService implements UserDetailsService {
	@Autowired
    private UserMapper userMapper;
	
	public int insertUser(UserDto dto) {
       return userMapper.insertUser(dto);
	}
	
	@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 System.out.println("입력된 아이디: " + username); // 확인용 로그
		UserDto user = userMapper.findByUserId(username);

        if (user == null) {
        	System.out.println("해당 아이디 없음: " + username);
            throw new UsernameNotFoundException("User not found: " + username);
        }

        System.out.println("DB에서 찾은 비밀번호: " + user.getUser_passwd());
        
        return new CustomUserDetails(user);
    }
}

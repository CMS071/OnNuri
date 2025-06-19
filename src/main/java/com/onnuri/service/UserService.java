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
        UserDto user = userMapper.findByUserId(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found: " + username);
        }

        return new CustomUserDetails(user);
    }
}

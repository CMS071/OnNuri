package com.onnuri.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.onnuri.dto.UserDto;

@Mapper
public interface UserMapper {
	public List<UserDto> selectUser();
	public UserDto selectUserDetail(@Param("user_num") int user_num);
	public int insertUser(UserDto dto);
	public int updateUser(UserDto dto);
	public int deleteUser(@Param("user_num") int user_num);
	UserDto findByUserId(@Param("user_id") String user_id);
	UserDto findByUserNickname(@Param("user_nickname") String user_nickname);
	UserDto findByUserEmail(@Param("user_email") String user_email);
}

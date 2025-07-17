package com.onnuri.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.onnuri.dto.DailyBoardDto;

@Mapper
public interface DailyBoardMapper {
	
	// 전체 게시글 조회
	List<DailyBoardDto> getAllDailyBoards();
	
	// 게시글 조회
	DailyBoardDto getDailyBoardById(int daily_idx);
	
	// 게시글 등록
	int insertDailyBoard(DailyBoardDto dto);
	
	// 게시글 수정
	int updateDailyBoard(DailyBoardDto dto);
	
	// 게시글 삭제
	int deleteDailyBoard(int daily_idx);
	
	// 조회수 증가
	void incrementViewCount(int daily_idx);
}

package com.onnuri.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onnuri.dao.DailyBoardMapper;
import com.onnuri.dto.DailyBoardDto;

@Service
public class DailyBoardService {
	
	@Autowired
	private DailyBoardMapper dailyBoardDao;
	
	// 전체 게시글 조회
	public List<DailyBoardDto> getAllDailyBoards() {
		return dailyBoardDao.getAllDailyBoards();
	}
	
	// 게시글 조회
	public DailyBoardDto getDailyBoardById(int daily_idx) {
		return dailyBoardDao.getDailyBoardById(daily_idx);
	}
	
	// 게시글 등록
	public int insertDailyBoard(DailyBoardDto dto) {
		return dailyBoardDao.insertDailyBoard(dto);
	}
	
	// 게시글 수정
	public int updateDailyBoard(DailyBoardDto dto) {
		return dailyBoardDao.updateDailyBoard(dto);
	}
	
	// 게시글 삭제
	public int deleteDailyBoard(int daily_idx) {
		return dailyBoardDao.deleteDailyBoard(daily_idx);
	}
	
	// 조회수 증가
	public void	incrementViewCount(int daily_idx) {		
		dailyBoardDao.incrementViewCount(daily_idx);
	}
}

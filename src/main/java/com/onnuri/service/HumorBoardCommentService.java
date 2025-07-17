package com.onnuri.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onnuri.dao.HumorBoardCommentMapper;
import com.onnuri.dto.HumorBoardCommentDto;

@Service
public class HumorBoardCommentService {
	
	@Autowired
	private HumorBoardCommentMapper humorBoardCommentMapper;
	
	// 댓글 전체 조회
	public List<HumorBoardCommentDto> getCommentsByHumorIdx(int humor_idx) {
		return humorBoardCommentMapper.getCommentsByHumorIdx(humor_idx);
	}
	
	// 댓글 등록
	public int insertComment(HumorBoardCommentDto dto) {
		return humorBoardCommentMapper.insertComment(dto);
	}
	
	// 댓글 삭제
	public int deleteComment(int humor_com_idx) {
		return humorBoardCommentMapper.deleteComment(humor_com_idx);
	}
	
	// 댓글 수정
	public int updateComment(HumorBoardCommentDto dto) {
		return humorBoardCommentMapper.updateComment(dto);
	}
	
	// 댓글 조회
	public HumorBoardCommentDto getCommentById(int humor_com_idx) {
		return humorBoardCommentMapper.getCommentById(humor_com_idx);
	}
	
	// 대댓글 등록 전 step 정렬 처리
	public int updateStep(HumorBoardCommentDto dto) {
		return humorBoardCommentMapper.updateStep(dto);
	}
	
}

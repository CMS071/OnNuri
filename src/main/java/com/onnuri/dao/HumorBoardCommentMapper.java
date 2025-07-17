package com.onnuri.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.onnuri.dto.HumorBoardCommentDto;

@Mapper
public interface HumorBoardCommentMapper {
	
	// 댓글 전체 조회
	List<HumorBoardCommentDto> getCommentsByHumorIdx(int humor_idx);
	
	// 댓글 등록
	int insertComment(HumorBoardCommentDto dto);
	
	// 댓글 삭제
	int deleteComment(int humor_com_idx);
	
	// 댓글 수정
	int updateComment(HumorBoardCommentDto dto);
	
	// 댓글 조회
	HumorBoardCommentDto getCommentById(int humor_com_idx);
	
	// 댓글 step 증가
	int updateStep(HumorBoardCommentDto dto);
}

package com.onnuri.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.onnuri.dto.HumorBoardDto;

@Mapper
public interface HumorBoardMapper {

    // 전체 게시글 조회
    List<HumorBoardDto> getAllHumors();

    // 게시글 하나 조회 (상세보기)
    HumorBoardDto getHumorById(int humor_idx);

    // 게시글 등록
    int insertHumor(HumorBoardDto dto);

    // 게시글 수정
    int updateHumor(HumorBoardDto dto);

    // 게시글 삭제
    int deleteHumor(int humor_idx);

    // 조회수 증가
    int incrementViewCount(int humor_idx);	
}

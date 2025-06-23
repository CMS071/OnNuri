package com.onnuri.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onnuri.dao.HumorBoardMapper;
import com.onnuri.dto.HumorBoardDto;

@Service
public class HumorBoardService {

	@Autowired
    HumorBoardMapper humorBoardMapper; 

    // 전체 게시글 조회
    public List<HumorBoardDto> getAllHumors() {
        return humorBoardMapper.getAllHumors();
    }

    // 게시글 상세 조회
    public HumorBoardDto getHumorById(int humor_idx) {
        return humorBoardMapper.getHumorById(humor_idx);
    }

    // 게시글 등록
    public int insertHumor(HumorBoardDto dto) {
        return humorBoardMapper.insertHumor(dto);
    }

    // 게시글 수정
    public int updateHumor(HumorBoardDto dto) {
        return humorBoardMapper.updateHumor(dto);
    }

    // 게시글 삭제
    public int deleteHumor(int humor_idx) {
        return humorBoardMapper.deleteHumor(humor_idx);
    }

    // 조회수 증가
    public int incrementViewCount(int humor_idx) {
    	return humorBoardMapper.incrementViewCount(humor_idx);
    }
}

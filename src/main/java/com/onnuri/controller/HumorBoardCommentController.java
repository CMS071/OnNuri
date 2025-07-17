package com.onnuri.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.onnuri.dto.HumorBoardCommentDto;
import com.onnuri.service.HumorBoardCommentService;

import jakarta.servlet.http.HttpSession;

@Controller
public class HumorBoardCommentController {
	
	@Autowired
	private HumorBoardCommentService humorBoardCommentService;
	
	// 댓글 목록 조회
	@RequestMapping("/humorBoard/detail/comments")
	public String commentList(int humor_idx, Model model) {
		List<HumorBoardCommentDto> comments = humorBoardCommentService.getCommentsByHumorIdx(humor_idx);
		model.addAttribute("commentList", comments);
		model.addAttribute("humor_idx", humor_idx);
		return "humorBoard/humorDetail";
	}
	
	// 댓글 등록
	@RequestMapping("/humorBoard/commentInsert")
	public String insertComment(HumorBoardCommentDto dto, HttpSession session) {
		int user_num = (int) session.getAttribute("user_num");
		dto.setUser_num(user_num);
		humorBoardCommentService.insertComment(dto);
		return "redirect:/humorBoard/detail?humor_idx=" + dto.getHumor_idx();
	}
	
	// 댓글 삭제
	@RequestMapping("/humorBoard/commentDelete")
	public String deleteComment(int humor_com_idx, int humor_idx) {
		humorBoardCommentService.deleteComment(humor_com_idx);
		return "redirect:/humorBoard/detail?humor_idx=" + humor_idx;
	}
	
	// 댓글 수정
	@RequestMapping("/humorBoard/commentUpdate")
	public String updateComment(HumorBoardCommentDto dto) {
		humorBoardCommentService.updateComment(dto);
		return "redirect:/humorBoard/detail?humor_idx=" + dto.getHumor_idx();
	}
	
	// 대댓글 등록
	@RequestMapping("/humorBoard/commentReply")
	public String replyComment(HumorBoardCommentDto dto, HttpSession session) {
		int user_num = (int) session.getAttribute("user_num");
		dto.setUser_num(user_num);
		
		// 기존 댓글들의 step 정렬
		humorBoardCommentService.updateStep(dto);
		
		// 대댓글 정보 설정
		dto.setHumor_com_step(dto.getHumor_com_step()+1);
		dto.setHumor_com_indent(dto.getHumor_com_indent()+1);
		
		humorBoardCommentService.insertComment(dto);
		return "redirect:/humorBoard/detail?humor_idx=" + dto.getHumor_idx();
	}
	
}

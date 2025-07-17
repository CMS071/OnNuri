package com.onnuri.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.onnuri.dto.DailyBoardDto;
import com.onnuri.service.DailyBoardService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class DailyBoardController {
	
	@Autowired
	private DailyBoardService dailyBoardService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setDisallowedFields("daily_img");
	}
	
	// 게시글 전체 목록 
	@RequestMapping("/dailyBoard/list")
	public String list(Model model) {
		List<DailyBoardDto> list = dailyBoardService.getAllDailyBoards();
		model.addAttribute("list", list);
		return "dailyBoard/dailyList";
	}
	
	// 게시글 상세보기
	@RequestMapping("/dailyBoard/detail")
	public String detail(@RequestParam("daily_idx") int daily_idx, Model model) {
		dailyBoardService.incrementViewCount(daily_idx);
		DailyBoardDto dto = dailyBoardService.getDailyBoardById(daily_idx);
		model.addAttribute("dto", dto);
		return "dailyBoard/dailyDetail";
	}
	
	// 게시글 작성
	@RequestMapping("/dailyBoard/write")
	public String write() {
		return "dailyBoard/dailyWrite";
	}
	
	// 게시글 작성 처리
	@RequestMapping("/dailyBoard/writeProcess")
	public String writeProcess(
			@ModelAttribute DailyBoardDto dto,
			@RequestParam(value="daily_img", required=false) List<MultipartFile> files,
			HttpSession session,
			HttpServletRequest request,
			Model model) {
		
		Integer user_num = (Integer) session.getAttribute("user_num");
		if (user_num==null) return "redirect:/";
		dto.setUser_num(user_num);
		
		String uploadPath="D:/upload/daily/";
		File uploadDir=new File(uploadPath);
		if (!uploadDir.exists()) uploadDir.mkdirs();
		
		List<String> savedFiles = new ArrayList<>();
		
		if (files != null) {
			for (MultipartFile file : files) {
				if (!file.isEmpty()) {
					try {
						String originName = file.getOriginalFilename();
						String saveName = System.currentTimeMillis() + "_"+originName;
						file.transferTo(new File(uploadDir, saveName));
						savedFiles.add("/img/daily/"+saveName);
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		
		if (!savedFiles.isEmpty()) {
			dto.setDaily_img(String.join(",",savedFiles));
		}
		
		dailyBoardService.insertDailyBoard(dto);
		return "redirect:/dailyBoard/list";
	}
	
	// 게시글 수정
	@RequestMapping("/dailyBoard/update")
	public String update(@RequestParam("daily_idx") int daily_idx, Model model) {
		DailyBoardDto dto = dailyBoardService.getDailyBoardById(daily_idx);
		model.addAttribute("dto", dto);
		return "dailyBoard/dailyUpdate";
	}
	
	// 게시글 수정 처리
	@RequestMapping("/dailyBoard/updateProcess")
	public String updateProcess(DailyBoardDto dto) {
		dailyBoardService.updateDailyBoard(dto);
		return "redirect:/dailyBoard/detail?daily_idx=" + dto.getDaily_idx();
	}
	
	// 게시글 삭제
	@RequestMapping("/dailyBoard/delete")
	public String delete(@RequestParam("daily_idx") int daily_idx) {
		dailyBoardService.deleteDailyBoard(daily_idx);
		return "redirect:/dailyBoard/list";
	}
}

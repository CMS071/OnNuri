package com.onnuri.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.onnuri.dto.HumorBoardDto;
import com.onnuri.service.HumorBoardService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class HumorBoardController {
	@Autowired
    private HumorBoardService humorBoardService;

    // 게시글 목록 페이지
    @RequestMapping("/humor/list")
    public String list(Model model) {
        List<HumorBoardDto> list = humorBoardService.getAllHumors();
        model.addAttribute("list", list);
        return "humorBoard/humorList";
    }

    // 게시글 상세보기 페이지
    @RequestMapping("/humor/detail")
    public String detail(@RequestParam("humor_idx") int humor_idx, Model model) {
    	humorBoardService.incrementViewCount(humor_idx); // 조회수 증가
        HumorBoardDto dto = humorBoardService.getHumorById(humor_idx);
        model.addAttribute("dto", dto);
        return "humorBoard/detail";
    }

    // 게시글 작성 폼
    @RequestMapping("/humor/writeForm")
    public String writeForm() {
        return "Humor/writeForm";
    }

    // 게시글 작성 처리
    @RequestMapping("/humor/write")
    public String write(HumorBoardDto dto,
            @RequestParam("humor_img") List<MultipartFile> files,
            HttpSession session,
            HttpServletRequest request,
            Model model) {

	Integer user_num = (Integer) session.getAttribute("user_num");
	if (user_num == null) return "redirect:/user/login";
	dto.setUser_num(user_num);
	
	String uploadPath = request.getServletContext().getRealPath("/resources/static/img/humor/");
	File uploadDir = new File(uploadPath);
	if (!uploadDir.exists()) uploadDir.mkdirs();
	
	List<String> savedFiles = new ArrayList<>();
	
	for (MultipartFile file : files) {
	if (!file.isEmpty()) {
	    try {
	        String originName = file.getOriginalFilename();
	        String saveName = System.currentTimeMillis() + "_" + originName;
	        file.transferTo(new File(uploadDir, saveName));
	        savedFiles.add("/resources/static/img/humor/" + saveName);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	  }
	}
	
	// 이미지 경로를 ,로 이어서 저장
	if (!savedFiles.isEmpty()) {
	dto.setHumor_img(String.join(",", savedFiles));
	}
	
	humorBoardService.insertHumor(dto);
	return "redirect:/humor/list";
    }

    // 게시글 수정 처리
    @RequestMapping("/humor/update")
    public String update(HumorBoardDto dto) {
    	humorBoardService.updateHumor(dto);
        return "redirect:/humor/detail?id=" + dto.getHumor_idx();
    }

    // 게시글 삭제 처리
    @RequestMapping("/humor/delete")
    public String delete(@RequestParam("id") int humor_idx) {
    	humorBoardService.deleteHumor(humor_idx);
        return "redirect:/humor/list";
    }
}

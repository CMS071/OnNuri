package com.onnuri.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class HumorBoardCommentDto {
	private int humor_com_idx; // 댓글 고유번호
	private String humor_com_contents; // 댓글 내용
	private LocalDateTime humor_com_date; // 댓글 작성,수정 일시
	private Integer humor_com_root; // 최상위 댓글
	private Integer humor_com_step; // 출력 순서 조정용
	private Integer humor_com_indent; // 들여쓰기
	private int user_num; // 회원 번호
	private int humor_idx; // 게시글 번호
	private String user_nickname; // 작성자 닉네임
}

package com.onnuri.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class DailyBoardDto {
	private int daily_idx;
	private String daily_title;
	private String daily_contents;
	private String daily_img;
	private LocalDateTime daily_date; 
	private int daily_cnt;
	private int user_num;
	private String user_nickname; 
}

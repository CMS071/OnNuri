package com.onnuri.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class HumorBoardDto {
	private int humor_idx;
    private String humor_title;
    private String humor_contents;
    private String humor_img;
    private LocalDateTime humor_date;
    private int humor_cnt;
    private int user_num;
    private String user_nickname;
}

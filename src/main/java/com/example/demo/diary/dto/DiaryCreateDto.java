package com.example.demo.diary.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DiaryCreateDto {
    private Long userId;

    private String content;
}

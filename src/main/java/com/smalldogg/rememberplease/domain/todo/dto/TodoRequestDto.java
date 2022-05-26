package com.smalldogg.rememberplease.domain.todo.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class TodoRequestDto {
    private String content;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime dueDateTime;
    private Boolean done;
    private Long folderId;
}

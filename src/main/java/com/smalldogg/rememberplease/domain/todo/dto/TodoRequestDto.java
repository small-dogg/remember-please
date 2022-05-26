package com.smalldogg.rememberplease.domain.todo.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class TodoRequestDto {
    private String content;
    private LocalDateTime dueDateTime;
    private Boolean done;
}

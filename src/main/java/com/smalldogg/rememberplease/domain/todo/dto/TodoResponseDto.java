package com.smalldogg.rememberplease.domain.todo.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class TodoResponseDto {
    private Long id;
    private String name;
    private String content;
    private LocalDateTime dueDateTime;
    private FolderResponseDto folder;
    private Boolean done;
}

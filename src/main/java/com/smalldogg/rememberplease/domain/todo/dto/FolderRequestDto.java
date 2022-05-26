package com.smalldogg.rememberplease.domain.todo.dto;

import lombok.Data;

@Data
public class FolderRequestDto {

    private Long id;
    private String name;
    private Long folderId;
}

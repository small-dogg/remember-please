package com.smalldogg.rememberplease.domain.todo.repository;

import com.smalldogg.rememberplease.domain.todo.dto.FolderRequestDto;

public interface FolderRepositoryCustom {
    void updateFolder(FolderRequestDto folderRequestDto);
}

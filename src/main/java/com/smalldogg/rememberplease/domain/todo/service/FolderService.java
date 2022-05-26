package com.smalldogg.rememberplease.domain.todo.service;

import com.smalldogg.rememberplease.domain.todo.dto.FolderRequestDto;
import com.smalldogg.rememberplease.domain.todo.dto.FolderResponseDto;

import java.util.List;

public interface FolderService {
    FolderResponseDto findFolderById(Long folderId);
    List<FolderResponseDto> findFolders();
    FolderResponseDto createFolder(FolderRequestDto folderRequestDto);
    void updateFolder(FolderRequestDto folderRequestDto);
    void deleteFolder(Long folderId);
}

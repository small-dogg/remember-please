package com.smalldogg.rememberplease.domain.todo.service;

import com.smalldogg.rememberplease.domain.todo.entity.Folder;
import com.smalldogg.rememberplease.domain.todo.dto.FolderRequestDto;
import com.smalldogg.rememberplease.domain.todo.dto.FolderResponseDto;
import com.smalldogg.rememberplease.domain.todo.mapper.FolderRequestMapper;
import com.smalldogg.rememberplease.domain.todo.mapper.FolderResponseMapper;
import com.smalldogg.rememberplease.domain.todo.mapper.FoldersResponseMapper;
import com.smalldogg.rememberplease.domain.todo.repository.FolderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FolderServiceImpl implements FolderService{

    private final FolderRepository folderRepository;


    @Override
    public FolderResponseDto findFolderById(Long folderId) {
        Optional<Folder> folderOptional = folderRepository.findById(folderId);
        Folder folder = folderOptional.orElseThrow(() -> new NoSuchElementException("폴더 없음"));

        return FolderResponseMapper.INSTANCE.toDto(folder);
    }

    @Override
    public List<FolderResponseDto> findFolders() {
        List<Folder> folders = folderRepository.findAll();
        return FoldersResponseMapper.INSTANCE.toDto(folders);
    }

    @Override
    public FolderResponseDto createFolder(FolderRequestDto folderRequestDto) {
        Folder folder = FolderRequestMapper.INSTANCE.toEntity(folderRequestDto);
        Folder save = folderRepository.save(folder);
        return FolderResponseMapper.INSTANCE.toDto(save);

    }

    @Override
    public void updateFolder(FolderRequestDto folderRequestDto) {
        Optional<Folder> folderOptional = folderRepository.findById(folderRequestDto.getId());
        Folder folder = folderOptional.orElseThrow(() -> new NoSuchElementException("폴더 없음"));

    }

    @Override
    public void deleteFolder(Long folderId) {
        Optional<Folder> folderOptional = folderRepository.findById(folderId);
        folderRepository.delete(folderOptional.orElseThrow(() -> new NoSuchElementException("폴더 없음")));
    }
}

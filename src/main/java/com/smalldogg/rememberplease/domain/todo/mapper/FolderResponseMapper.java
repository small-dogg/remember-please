package com.smalldogg.rememberplease.domain.todo.mapper;

import com.smalldogg.rememberplease.domain.GenericMapper;
import com.smalldogg.rememberplease.domain.todo.entity.Folder;
import com.smalldogg.rememberplease.domain.todo.dto.FolderResponseDto;
import org.mapstruct.factory.Mappers;

public interface FolderResponseMapper extends GenericMapper<FolderResponseDto, Folder> {
    FolderResponseMapper INSTANCE = Mappers.getMapper(FolderResponseMapper.class);
}

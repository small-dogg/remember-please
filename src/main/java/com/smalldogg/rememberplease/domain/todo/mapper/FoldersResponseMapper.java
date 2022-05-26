package com.smalldogg.rememberplease.domain.todo.mapper;

import com.smalldogg.rememberplease.domain.GenericMapper;
import com.smalldogg.rememberplease.domain.todo.entity.Folder;
import com.smalldogg.rememberplease.domain.todo.dto.FolderResponseDto;
import org.mapstruct.factory.Mappers;

import java.util.List;

public interface FoldersResponseMapper extends GenericMapper<List<FolderResponseDto>, List<Folder>> {
    FoldersResponseMapper INSTANCE = Mappers.getMapper(FoldersResponseMapper.class);
}

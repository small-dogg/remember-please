package com.smalldogg.rememberplease.domain.todo.mapper;

import com.smalldogg.rememberplease.domain.GenericMapper;
import com.smalldogg.rememberplease.domain.todo.entity.Folder;
import com.smalldogg.rememberplease.domain.todo.dto.FolderRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface FolderRequestMapper extends GenericMapper<FolderRequestDto, Folder> {
    FolderRequestMapper INSTANCE = Mappers.getMapper(FolderRequestMapper.class);
}

package com.smalldogg.rememberplease.domain.todo.mapper;

import com.smalldogg.rememberplease.domain.GenericMapper;
import com.smalldogg.rememberplease.domain.todo.dto.TodoResponseDto;
import com.smalldogg.rememberplease.domain.todo.entity.Todo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TodoResponseMapper extends GenericMapper<TodoResponseDto, Todo> {
    TodoResponseMapper INSTANCE = Mappers.getMapper(TodoResponseMapper.class);
}

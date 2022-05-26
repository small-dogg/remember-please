package com.smalldogg.rememberplease.domain.todo.mapper;

import com.smalldogg.rememberplease.domain.GenericMapper;
import com.smalldogg.rememberplease.domain.todo.entity.Todo;
import com.smalldogg.rememberplease.domain.todo.dto.TodoRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TodoRequestMapper extends GenericMapper<TodoRequestDto, Todo> {
    TodoRequestMapper INSTANCE = Mappers.getMapper(TodoRequestMapper.class);


}

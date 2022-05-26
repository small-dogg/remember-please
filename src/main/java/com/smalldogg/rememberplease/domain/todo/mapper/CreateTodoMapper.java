package com.smalldogg.rememberplease.domain.todo.mapper;

import com.smalldogg.rememberplease.domain.GenericMapper;
import com.smalldogg.rememberplease.domain.todo.entity.Todo;
import com.smalldogg.rememberplease.domain.todo.dto.CreateTodoDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CreateTodoMapper extends GenericMapper<CreateTodoDto, Todo> {
    CreateTodoMapper INSTANCE = Mappers.getMapper(CreateTodoMapper.class);
}

package com.smalldogg.rememberplease.domain.todo.mapper;

import com.smalldogg.rememberplease.domain.GenericMapper;
import com.smalldogg.rememberplease.domain.todo.Todo;
import com.smalldogg.rememberplease.domain.todo.dto.CreateTodoDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CreateTodoMapper extends GenericMapper<CreateTodoDto, Todo> {
    Todo createTodoDtoToEntity(CreateTodoDto createTodoDto);
}

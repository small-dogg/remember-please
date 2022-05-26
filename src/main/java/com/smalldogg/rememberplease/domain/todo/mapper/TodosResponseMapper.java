package com.smalldogg.rememberplease.domain.todo.mapper;

import com.smalldogg.rememberplease.domain.GenericMapper;
import com.smalldogg.rememberplease.domain.todo.entity.Todo;
import com.smalldogg.rememberplease.domain.todo.dto.TodoResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TodosResponseMapper extends GenericMapper<List<TodoResponseDto>, List<Todo>> {
    TodosResponseMapper INSTANCE = Mappers.getMapper(TodosResponseMapper.class);
}

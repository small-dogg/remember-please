package com.smalldogg.rememberplease.domain.todo.mapper;

import com.smalldogg.rememberplease.domain.GenericMapper;
import com.smalldogg.rememberplease.domain.todo.Todo;
import com.smalldogg.rememberplease.domain.todo.dto.TodoResponseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TodoResponseMapper extends GenericMapper<List<TodoResponseDto>, List<Todo>> {
}

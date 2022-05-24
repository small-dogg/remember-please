package com.smalldogg.rememberplease.domain.todo.mapper;

import com.smalldogg.rememberplease.domain.GenericMapper;
import com.smalldogg.rememberplease.domain.todo.Todo;
import com.smalldogg.rememberplease.domain.todo.dto.TodoRequestDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TodoRequestMapper extends GenericMapper<TodoRequestDto, Todo> {
}

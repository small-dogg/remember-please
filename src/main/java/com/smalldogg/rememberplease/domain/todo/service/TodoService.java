package com.smalldogg.rememberplease.domain.todo.service;

import com.smalldogg.rememberplease.domain.todo.entity.Todo;
import com.smalldogg.rememberplease.domain.todo.dto.TodoRequestDto;
import com.smalldogg.rememberplease.domain.todo.dto.TodoResponseDto;

import java.util.List;

public interface TodoService {
    TodoResponseDto findTodo(Long todoId);
    List<TodoResponseDto> findTodos();

    Todo createTodo(TodoRequestDto todoRequestDto);

    void deleteTodo(Long todoId);

    void updateTodo(Long todoId, TodoRequestDto todoRequestDto);
}

package com.smalldogg.rememberplease.domain.todo;

import com.smalldogg.rememberplease.domain.todo.dto.CreateTodoDto;
import com.smalldogg.rememberplease.domain.todo.dto.TodoResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TodoService {
    TodoResponseDto findTodo(String todoId);
    List<TodoResponseDto> findTodos();

    Todo createTodo(CreateTodoDto createTodoDto);

    void deleteTodo(String todoId);
}

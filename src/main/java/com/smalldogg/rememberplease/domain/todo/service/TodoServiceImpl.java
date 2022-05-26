package com.smalldogg.rememberplease.domain.todo.service;

import com.smalldogg.rememberplease.domain.todo.entity.Todo;
import com.smalldogg.rememberplease.domain.todo.repository.TodoRepository;
import com.smalldogg.rememberplease.domain.todo.dto.CreateTodoDto;
import com.smalldogg.rememberplease.domain.todo.dto.TodoRequestDto;
import com.smalldogg.rememberplease.domain.todo.dto.TodoResponseDto;
import com.smalldogg.rememberplease.domain.todo.mapper.CreateTodoMapper;
import com.smalldogg.rememberplease.domain.todo.mapper.TodoRequestMapper;
import com.smalldogg.rememberplease.domain.todo.mapper.TodosResponseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;

    @Override
    public TodoResponseDto findTodo(Long todoId) {
        todoRepository.findById(todoId);
        return new TodoResponseDto();
    }

    @Override
    public List<TodoResponseDto> findTodos() {
        return TodosResponseMapper.INSTANCE.toDto(todoRepository.findAll());
    }

    @Override
    public Todo createTodo(CreateTodoDto createTodoDto) {
        return todoRepository.save(CreateTodoMapper.INSTANCE.toEntity(createTodoDto));
    }

    @Override
    public void deleteTodo(Long todoId) {
        todoRepository.deleteById(todoId);
    }

    @Override
    public void updateTodo(Long todoId, TodoRequestDto todoRequestDto) {
        Optional<Todo> todoOptional = todoRepository.findById(todoId);

        Todo todo = todoOptional.orElseThrow(() -> new NoSuchElementException("대상이 존재하지 않음"));
        TodoRequestMapper.INSTANCE.updateFromDto(todoRequestDto,todo);
    }
}

package com.smalldogg.rememberplease.domain.todo;

import com.smalldogg.rememberplease.domain.todo.dto.CreateTodoDto;
import com.smalldogg.rememberplease.domain.todo.dto.TodoResponseDto;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class todoServiceImpl implements TodoService{

    private final TodoRepository todoRepository;

    @Override
    public TodoResponseDto findTodo(String todoId) {
        todoRepository.findById(todoId);
        return new TodoResponseDto();
    }

    @Override
    public List<TodoResponseDto> findTodos() {
        todoRepository.findAll();
        return null;
    }

    @Override
    public Todo createTodo(CreateTodoDto createTodoDto) {

//        todoRepository.save(createTodoDto);
        return new Todo();
    }

    @Override
    public void deleteTodo(String todoId) {
        todoRepository.deleteById(todoId);
    }
}

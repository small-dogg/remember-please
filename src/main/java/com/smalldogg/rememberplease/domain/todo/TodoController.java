package com.smalldogg.rememberplease.domain.todo;

import com.smalldogg.rememberplease.domain.todo.dto.CreateTodoDto;
import com.smalldogg.rememberplease.domain.todo.dto.TodoResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/todo")
public class TodoController {

    private final TodoService todoService;


    @GetMapping("/{todoId}")
    public Todo getTodo(@PathVariable String todoId) {
        todoService.findTodo(todoId);
        return null;
    }

    @GetMapping
    public List<TodoResponseDto> getTodos() {
        return todoService.findTodos();
    }

    @PostMapping
    public Todo createTodo(CreateTodoDto param) {
        return todoService.createTodo(param);
    }

    @DeleteMapping("/{todoId}")
    public void deleteTodo(@PathVariable String todoId) {
        todoService.deleteTodo(todoId);
    }
}

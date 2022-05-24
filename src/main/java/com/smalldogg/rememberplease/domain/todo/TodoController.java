package com.smalldogg.rememberplease.domain.todo;

import com.smalldogg.rememberplease.domain.todo.dto.CreateTodoDto;
import com.smalldogg.rememberplease.domain.todo.dto.TodoRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
@RequestMapping("/")
public class TodoController {

    private final TodoService todoService;

    @GetMapping
    public String getTodos(Model model) {
        model.addAttribute("todos", todoService.findTodos());
        return "todos";
    }

    @GetMapping("/{todoId}")
    public Todo getTodo(@PathVariable Long todoId) {
        todoService.findTodo(todoId);
        return null;
    }

    @GetMapping("/add")
    public String getTodoAddForm(Model model) {
        return "todoAddForm";
    }

    @PostMapping("/add")
    public String addTodo(CreateTodoDto param) {
        todoService.createTodo(param);
        return "redirect:/";
    }

    @GetMapping("/{todoId}/edit")
    public String editTodo(@PathVariable Long todoId, Model model) {
        model.addAttribute("todo", todoService.findTodo(todoId));
        return "todoEditForm";
    }

    @PostMapping("/{todoId}/edit")
    public String editTodo(@PathVariable Long todoId, @ModelAttribute TodoRequestDto todoRequestDto) {
        todoService.updateTodo(todoId, todoRequestDto);
        return "redirect:/{todoId}";
    }

    @PostMapping("/{todoId}/delete")
    public String deleteTodo(@PathVariable Long todoId) {
        todoService.deleteTodo(todoId);
        return "redirect:/";
    }
}

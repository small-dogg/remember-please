package com.smalldogg.rememberplease.domain.todo.controller;

import com.smalldogg.rememberplease.domain.todo.dto.FolderResponseDto;
import com.smalldogg.rememberplease.domain.todo.entity.Todo;
import com.smalldogg.rememberplease.domain.todo.dto.TodoRequestDto;
import com.smalldogg.rememberplease.domain.todo.service.FolderService;
import com.smalldogg.rememberplease.domain.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/")
public class TodoController {

    private final TodoService todoService;
    private final FolderService folderService;

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
        List<FolderResponseDto> folders = folderService.findFolders();
        model.addAttribute("folders", folders);
        return "todoAddForm";
    }

    @PostMapping("/add")
    public String createTodo(TodoRequestDto param) {
        todoService.createTodo(param);
        return "redirect:/";
    }

    @GetMapping("/{todoId}/edit")
    public String editTodoForm(@PathVariable Long todoId, Model model) {
        List<FolderResponseDto> folders = folderService.findFolders();
        model.addAttribute("folders", folders);
        model.addAttribute("todo", todoService.findTodo(todoId));
        return "todoEditForm";
    }

    @PostMapping("/{todoId}/edit")
    public String editTodo(@PathVariable Long todoId, @ModelAttribute TodoRequestDto todoRequestDto) {
        todoService.updateTodo(todoId, todoRequestDto);
        return "redirect:/";
    }

    @PostMapping("/{todoId}/delete")
    public String deleteTodo(@PathVariable Long todoId) {
        todoService.deleteTodo(todoId);
        return "redirect:/";
    }
}

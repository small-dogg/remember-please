package com.smalldogg.rememberplease.domain.todo.service;

import com.smalldogg.rememberplease.domain.todo.entity.Folder;
import com.smalldogg.rememberplease.domain.todo.entity.Todo;
import com.smalldogg.rememberplease.domain.todo.mapper.TodoResponseMapper;
import com.smalldogg.rememberplease.domain.todo.repository.FolderRepository;
import com.smalldogg.rememberplease.domain.todo.repository.TodoRepository;
import com.smalldogg.rememberplease.domain.todo.dto.TodoRequestDto;
import com.smalldogg.rememberplease.domain.todo.dto.TodoResponseDto;
import com.smalldogg.rememberplease.domain.todo.mapper.TodosResponseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;
    private final FolderRepository folderRepository;

    @Override
    public TodoResponseDto findTodo(Long todoId) {
        Optional<Todo> todoOptional = todoRepository.findById(todoId);
        Todo todo = todoOptional.orElseThrow(() -> new NoSuchElementException("Todo 없음"));
        return TodoResponseMapper.INSTANCE.toDto(todo);
    }

    @Override
    public List<TodoResponseDto> findTodos() {
        return TodosResponseMapper.INSTANCE.toDto(todoRepository.findAll());
    }

    @Override
    public Todo createTodo(TodoRequestDto todoRequestDto) {
        Optional<Folder> folderOptional = folderRepository.findById(todoRequestDto.getFolderId());
        Folder folder = folderOptional.orElseThrow(() -> new NoSuchElementException("분류 없음"));
        Todo todo = new Todo(todoRequestDto.getContent(), todoRequestDto.getDueDateTime(), folder);
        return todoRepository.save(todo);
    }

    @Override
    public void deleteTodo(Long todoId) {
        todoRepository.deleteById(todoId);
    }

    @Override
    public void updateTodo(Long todoId, TodoRequestDto param) {
        Optional<Todo> todoOptional = todoRepository.findById(todoId);

        Todo todo = todoOptional.orElseThrow(() -> new NoSuchElementException("대상이 존재하지 않음"));

        if(param.getFolderId()!=null) {
            Folder folder = folderRepository.getById(param.getFolderId());
            if (todo.getFolder() != folder) {
                todo.changeFolder(folder);
            }
        }
        if(contentChanged(param, todo)){
            todo.changeContent(param.getContent());
        }
        if(doneChanged(param, todo)){
            todo.changeStatus(param.getDone());
        }
        if(dueDateChanged(param, todo)){
            todo.changeDueDateTime(param.getDueDateTime());
        }
    }

    private boolean dueDateChanged(TodoRequestDto param, Todo todo) {
        return param.getDueDateTime() != null && todo.getDueDateTime() != param.getDueDateTime();
    }

    private boolean doneChanged(TodoRequestDto param, Todo todo) {
        return param.getDone() != null && todo.getDone() != param.getDone();
    }

    private boolean contentChanged(TodoRequestDto param, Todo todo) {
        return StringUtils.hasText(param.getContent()) && todo.getContent() != param.getContent();
    }
}

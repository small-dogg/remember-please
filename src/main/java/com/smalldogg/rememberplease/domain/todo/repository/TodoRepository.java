package com.smalldogg.rememberplease.domain.todo.repository;

import com.smalldogg.rememberplease.domain.todo.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}

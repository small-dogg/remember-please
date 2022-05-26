package com.smalldogg.rememberplease.domain.todo.repository;

import com.smalldogg.rememberplease.domain.todo.entity.Folder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FolderRepository extends JpaRepository<Folder, Long>, FolderRepositoryCustom {
}

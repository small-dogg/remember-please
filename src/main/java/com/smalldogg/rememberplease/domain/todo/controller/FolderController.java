package com.smalldogg.rememberplease.domain.todo.controller;

import com.smalldogg.rememberplease.domain.todo.service.FolderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class FolderController {
    private final FolderService folderService;
}

package com.smalldogg.rememberplease.domain.todo.controller;

import com.smalldogg.rememberplease.domain.todo.service.FolderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/folder")
@RequiredArgsConstructor
public class FolderController {
    private final FolderService folderService;

    @GetMapping
    public String addFolderForm(){
        return "folderAddForm";
    }

    @PostMapping
    public String createFolder(@RequestParam String name){
        folderService.createFolder(name);
        return "redirect:/";
    }

    @PostMapping("{folderId}/delete")
    public String deleteFolder(@PathVariable String folderId){
        System.out.println("name = " + folderId);
        return "redirect:/";
    }
}

package com.smalldogg.rememberplease.domain.todo.service;

import com.smalldogg.rememberplease.domain.todo.dto.FolderRequestDto;
import com.smalldogg.rememberplease.domain.todo.dto.FolderResponseDto;
import com.smalldogg.rememberplease.domain.todo.repository.FolderRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class FolderServiceImplTest {

    @Autowired
    FolderService folderService;

    @Autowired
    FolderRepository folderRepository;

    @BeforeEach
    void setup() {
        FolderRequestDto folderRequestDto1 = new FolderRequestDto();
        FolderRequestDto folderRequestDto2 = new FolderRequestDto();
        folderService.createFolder("학습");
        folderService.createFolder("집안일");
    }

    @Test
    void findById() {
        FolderResponseDto folderById = folderService.findFolderById(1L);
        assertThat(folderById.getName()).isEqualTo("학습");
    }

}
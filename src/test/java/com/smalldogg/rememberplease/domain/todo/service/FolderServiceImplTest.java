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
        folderRequestDto1.setId(1L);
        folderRequestDto1.setName("학습");
        FolderRequestDto folderRequestDto2 = new FolderRequestDto();
        folderRequestDto2.setId(2L);
        folderRequestDto2.setName("집안일");
        folderService.createFolder(folderRequestDto1);
        folderService.createFolder(folderRequestDto2);
    }

    @Test
    void findById() {
        FolderResponseDto folderById = folderService.findFolderById(1L);
        assertThat(folderById.getName()).isEqualTo("학습");
    }

}
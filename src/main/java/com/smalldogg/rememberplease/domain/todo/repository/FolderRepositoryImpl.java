package com.smalldogg.rememberplease.domain.todo.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.smalldogg.rememberplease.domain.todo.dto.FolderRequestDto;
import lombok.RequiredArgsConstructor;

import static com.smalldogg.rememberplease.domain.todo.entity.QFolder.*;

@RequiredArgsConstructor
public class FolderRepositoryImpl implements FolderRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    @Override
    public void updateFolder(FolderRequestDto folderRequestDto){
        queryFactory.update(folder)
                .set(folder.name,folderRequestDto.getName())
                .where(folder.id.eq(folderRequestDto.getId()));
    }
}

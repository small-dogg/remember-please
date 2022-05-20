package com.smalldogg.rememberplease.domain.todo;

import com.smalldogg.rememberplease.domain.BaseTimeEntity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Todo extends BaseTimeEntity {

    @Id
    private String id;
    private String content;
    private LocalDateTime dueDateTime;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "folder_id")
    private Folder folder;

}

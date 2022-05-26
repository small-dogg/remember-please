package com.smalldogg.rememberplease.domain.todo.entity;

import com.smalldogg.rememberplease.domain.BaseTimeEntity;
import com.smalldogg.rememberplease.domain.todo.entity.Folder;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
public class Todo extends BaseTimeEntity {

    @Id @GeneratedValue
    private Long id;
    private String content;
    private LocalDateTime dueDateTime;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "folder_id")
    private Folder folder;
    private Boolean done;

}

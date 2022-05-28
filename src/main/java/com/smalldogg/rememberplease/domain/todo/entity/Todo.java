package com.smalldogg.rememberplease.domain.todo.entity;

import com.smalldogg.rememberplease.domain.BaseTimeEntity;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
@DynamicUpdate
public class Todo extends BaseTimeEntity {

    @Id @GeneratedValue
    private Long id;
    private String content;
    private LocalDateTime dueDateTime;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "folder_id")
    private Folder folder;
    private Boolean done;

    public Todo(String content, LocalDateTime dueDateTime, Folder folder) {
        this.content = content;
        this.dueDateTime = dueDateTime;
        this.folder = folder;
    }

    public void changeContent(String content){
        this.content = content;
    }

    public void changeStatus(Boolean done) {
        this.done = done;
    }

    public void changeFolder(Folder folder) {
        this.folder = folder;
        folder.getTodo().add(this);
    }

    public void changeDueDateTime(LocalDateTime dueDateTime) {
        this.dueDateTime = dueDateTime;
    }
}

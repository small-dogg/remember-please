package com.smalldogg.rememberplease.domain.todo.entity;

import com.smalldogg.rememberplease.domain.BaseTimeEntity;
import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
public class Folder extends BaseTimeEntity {
    @Id
    @Column(name="folder_id")
    private Long id;
    private String name;
    @OneToMany(mappedBy = "folder")
    private List<Todo> todo;
}

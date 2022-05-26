package com.smalldogg.rememberplease.domain.todo.entity;

import com.smalldogg.rememberplease.domain.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Folder extends BaseTimeEntity {
    @Id @GeneratedValue
    @Column(name="folder_id")
    private Long id;
    private String name;
    @OneToMany(mappedBy = "folder")
    private List<Todo> todo;

    public Folder(String name) {
        this.name = name;
    }
}

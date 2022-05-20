package com.smalldogg.rememberplease.domain.todo;

import javax.persistence.*;
import java.util.List;

@Entity
public class Folder {
    @Id
    @Column(name="folder_id")
    private String id;
    private String name;
    private String description;
    @OneToMany(mappedBy = "folder")
    private List<Todo> todo;
}

package com.smalldogg.rememberplease.domain.todo;

import com.smalldogg.rememberplease.domain.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
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
    private LocalDate dueDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "folder_id")
    private Folder folder;
    private Boolean done;

}

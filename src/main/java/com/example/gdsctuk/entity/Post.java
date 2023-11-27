package com.example.gdsctuk.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table
@NoArgsConstructor
@Getter
@SQLDelete(sql = "UPDATE post SET deleted = true WHERE post_Id = ?") // delete 요청이 들어왔을 때 발생하는 쿼리문
@Where(clause = "deleted = false")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    @Column(columnDefinition = "TEXT")
    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column
    private String postWriter;

    @Column
    private String postPasswd;

    @CreatedDate // INSERT 시 자동으로 값을 채워줌
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @LastModifiedDate // UPDATE 시 자동으로 값을 채워줌
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "post")
    private List<Comment> comments;

    private boolean deleted = Boolean.FALSE;

    @Builder
    public Post(Long postId, String title, String content, String postWriter, String postPasswd, boolean deleted) {
        this.postId = postId;
        this.title = title;
        this.content = content;
        this.postWriter = postWriter;
        this.postPasswd = postPasswd;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.deleted = deleted;

    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
        this.updatedAt = LocalDateTime.now();

    }

}

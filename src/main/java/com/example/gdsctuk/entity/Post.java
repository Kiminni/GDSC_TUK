package com.example.gdsctuk.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Entity
@Table
@Builder
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

    @OneToMany(mappedBy = "post")
    private List<Comment> comments;
    public Post() {}

    public Post(Long postId, String title, String content, String postWriter, String postPasswd) {
        this.postId = postId;
        this.title = title;
        this.content = content;
        this.postWriter = postWriter;
        this.postPasswd = postPasswd;
    }
}

package com.example.gdsctuk.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Entity
@Getter
@Table
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column
    private String user;

    @Column
    private String commentPasswd;

    @ManyToOne
    @JoinColumn(name="postId")
    private Post post;
    public Comment() {
    }
    @Builder
    public Comment(Long id, String content, String user, String commentPasswd) {
        this.id = id;
        this.content = content;
        this.user = user;
        this.commentPasswd = commentPasswd;
    }


}

package com.example.gdsctuk.dto;

import com.example.gdsctuk.entity.Post;
import lombok.*;

@Getter
@ToString
@NoArgsConstructor
public class PostResponse {
    private Long postId;
    private String title;
    private String content;
    private String postWriter;
    private String postPasswd;

    public PostResponse(Post post) {
        this.postId = post.getPostId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.postWriter = post.getPostWriter();
        this.postPasswd = post.getPostPasswd();
    }
}

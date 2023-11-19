package com.example.gdsctuk.dto;

import lombok.*;
import com.example.gdsctuk.entity.Post;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PostRequest {

    private String title;
    private String content;
    private String postWriter;
    private String postPasswd;

    public Post toEntity() {
        return Post.builder()
                .title(title)
                .content(content)
                .postWriter(postWriter)
                .postPasswd(postPasswd)
                .build();
    }
}
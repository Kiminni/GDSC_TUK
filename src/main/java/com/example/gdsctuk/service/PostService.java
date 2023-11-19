package com.example.gdsctuk.service;

import com.example.gdsctuk.repository.PostRepository;
import com.example.gdsctuk.dto.PostRequest;
import com.example.gdsctuk.dto.PostResponse;
import com.example.gdsctuk.entity.Post;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Transactional
    public List<Post> getAllPost() {
        return postRepository.findAll();
    }

    @Transactional
    public PostResponse getPostById(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("잘못된 Post ID 입니다."));
        return new PostResponse(post);
    }

    @Transactional
    public Post createPost(PostRequest post) {
        return postRepository.save(post.toEntity());
    }

    @Transactional
    public Post updatePost(Long id, PostRequest updatedPost) {
        Post post = postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("잘못된 Post ID 입니다."));
        post.update(updatedPost.getTitle(), post.getContent());

        return postRepository.save(post);
    }

    @Transactional
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}


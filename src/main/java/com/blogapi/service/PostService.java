package com.blogapi.service;

import java.util.List;
import com.blogapi.model.entity.Post;

public interface PostService {

    Post createPost(Post post);

    List<Post> getAllPosts();

    Post getPostById(Long id);

    Post updatePost(Long id, Post post);

    void deletePost(Long id);
}
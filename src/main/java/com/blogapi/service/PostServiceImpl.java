package com.blogapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogapi.model.entity.Post;
import com.blogapi.repository.PostRepository;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post getPostById(Long id) {
        return postRepository.findById(id).orElse(null);
    }

    @Override
    public Post updatePost(Long id, Post post) {

        Post existingPost = postRepository.findById(id).orElse(null);

        if(existingPost != null) {
            existingPost.setTitle(post.getTitle());
            existingPost.setContent(post.getContent());
            existingPost.setUser(post.getUser());
            existingPost.setCategory(post.getCategory());

            return postRepository.save(existingPost);
        }

        return null;
    }

    @Override
    public void deletePost(Long id) {

        Post post = postRepository.findById(id).orElse(null);

        if(post != null) {
            postRepository.delete(post);
        }
    }
}
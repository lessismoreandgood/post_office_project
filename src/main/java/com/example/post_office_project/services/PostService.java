package com.example.post_office_project.services;

import com.example.post_office_project.models.Post;

import java.util.List;

public interface PostService {
    List<Post> getAllPosts();

    Post getPostById(Long id);

    Post savePost(Post post);

    void deletePostById(Long id);
}

package com.example.post_office_project.rest;

import com.example.post_office_project.models.Post;
import com.example.post_office_project.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/post/")
public class PostRestController {
    @Autowired
    PostService postService;

    @GetMapping("{post_id}")
    public ResponseEntity<Post> getPost(@PathVariable(name = "post_id") Long postId){
        Post post = postService.getPostById(postId);

        return ((post != null) ?  new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("create")
    public ResponseEntity<Post> addPost(@RequestBody Post post){
        if (post == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        postService.savePost(post);

        return new ResponseEntity<>(post, HttpStatus.CREATED);
    }

    @PutMapping("update")
    public ResponseEntity<Post> updateUser(@RequestBody Post post){
        if (post == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        postService.savePost(post);

        return new ResponseEntity<>(post, HttpStatus.CREATED);
    }

    @DeleteMapping("delete/{post_id}")
    public ResponseEntity<Post> deleteUserById(@PathVariable(name = "post_id") Long postId){
        Post post = postService.getPostById(postId);

        if (post == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        postService.deletePostById(postId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("all")
    public ResponseEntity<Post> getAllPosts(){
        List<Post> postList = postService.getAllPosts();

        return ((postList != null) ?  new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}

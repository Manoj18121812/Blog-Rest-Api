package com.example.Blog_Rest_Api.Controller;

import com.example.Blog_Rest_Api.Entity.Post;
import com.example.Blog_Rest_Api.Service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {


    private final PostService service;

    public PostController(PostService service){
        this.service = service;
    }
    @PostMapping
    public Post create(@PathVariable Post post){
        return service.create(post);
    }

    @GetMapping
    public List<Post> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Post getById(@PathVariable Integer id){
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Post update(Integer id,Post post){
        return service.update(id,post);
    }

    @DeleteMapping("/{id}")
    public String delete(Integer id){
        return service.delete(id) ? "Post Deleted" : "Post not found";
    }

    @PostMapping("/{postId}/like/{userId}")
    public String likePost(@PathVariable Integer postId,@PathVariable Integer userId){
        return service.likePost(postId,userId);
    }

    @PostMapping("/{postId}/unlike/{userId}")
    public String unlikePost(@PathVariable Integer postId,@PathVariable Integer userId){
        return service.UnlikePost(postId,userId);
    }


}

package com.example.Blog_Rest_Api.Controller;

import com.example.Blog_Rest_Api.Entity.Comment;
import com.example.Blog_Rest_Api.Service.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    private final CommentService service;

    public CommentController(CommentService service){
        this.service = service;
    }

    @PostMapping("/postId")
    public Comment addComment(@PathVariable Integer postId ,@RequestBody Comment comment){
        return service.AddComment(postId,comment);
    }

    @GetMapping("/{postId}")
    public List<Comment> getComments(@PathVariable Integer postId) {
        return service.getCommentsByPost(postId);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        return service.delete(id) ? "Comment Deleted" : "Comment Not Found";
    }
}

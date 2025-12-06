package com.example.Blog_Rest_Api.Service;

import com.example.Blog_Rest_Api.Entity.Comment;
import com.example.Blog_Rest_Api.Entity.Post;
import com.example.Blog_Rest_Api.Repository.CommentRepository;
import com.example.Blog_Rest_Api.Repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CommentService {

    private final CommentRepository commentRepo;
    private final PostRepository postRepo;

    public CommentService(CommentRepository commentRepo, PostRepository postRepo) {
        this.commentRepo = commentRepo;
        this.postRepo = postRepo;
    }

    public Comment addComment(Integer postId, Comment comment) {
        Post post = postRepo.findById(postId).orElse(null);
        if (post == null) return null;

        comment.setPost(post);
        return commentRepo.save(comment);
    }

    public List<Comment> getCommentsByPost(Integer postId) {
        Post post = postRepo.findById(postId).orElse(null);
        return post != null ? post.getComments() : Collections.emptyList();
    }

    public boolean delete(Integer id) {
        if (!commentRepo.existsById(id)) return false;
        commentRepo.deleteById(id);
        return true;
    }
}

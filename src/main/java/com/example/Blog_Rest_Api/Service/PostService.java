package com.example.Blog_Rest_Api.Service;

import com.example.Blog_Rest_Api.Entity.Post;
import com.example.Blog_Rest_Api.Entity.User;
import com.example.Blog_Rest_Api.Repository.PostRepository;
import com.example.Blog_Rest_Api.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepo;
    private final UserRepository userRepo;

    public PostService(PostRepository postRepo, UserRepository userRepo) {
        this.postRepo = postRepo;
        this.userRepo = userRepo;
    }

    public Post create(Post post){
        post.setLikedUsers(new HashSet<>());
        return postRepo.save(post);
    }

    public List<Post> getAll(){
        return postRepo.findAll();
    }

    public Post getById(Integer id){
        return postRepo.findById(id).get();
    }

    public Post update(Integer id, Post updated){
        Post old = postRepo.findById(id).orElse(null);
        if(old==null) return null;

        old.setTitle(updated.getTitle());
        old.setContent(updated.getContent());

        return postRepo.save(old);
    }
    public boolean delete(Integer id){
        if(!postRepo.existsById(id)){
            return false;
        }
        postRepo.deleteById(id);
        return true;
    }

    //Like Post

    public String likePost(Integer postId,Integer userId){
        Post post = postRepo.findById(postId).orElse(null);
        User user = userRepo.findById(userId).orElse(null);

        if(post==null || user ==null) return "Post or user not found";

        post.getLikedUsers().add(user);
        postRepo.save(post);

        return "Post Liked !";
    }

    //unlike

    public String UnlikePost(Integer postId,Integer userId){
        Post post = postRepo.findById(postId).orElse(null);
        User user = userRepo.findById(userId).orElse(null);

        if(post==null || user == null) return "post or user not found ";

        post.getLikedUsers().remove(user);
        postRepo.save(post);

        return "Post Unliked !";
    }
}

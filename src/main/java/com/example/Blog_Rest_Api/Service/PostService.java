package com.example.Blog_Rest_Api.Service;

import com.example.Blog_Rest_Api.Repository.PostRepository;
import com.example.Blog_Rest_Api.Repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    private final PostRepository postRepo;
    private final UserRepository userRepo;

    public PostService(PostRepository postRepo, UserRepository userRepo) {
        this.postRepo = postRepo;
        this.userRepo = userRepo;
    }

    
}

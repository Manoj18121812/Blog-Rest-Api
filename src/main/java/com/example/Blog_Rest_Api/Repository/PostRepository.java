package com.example.Blog_Rest_Api.Repository;

import com.example.Blog_Rest_Api.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Integer> {
}

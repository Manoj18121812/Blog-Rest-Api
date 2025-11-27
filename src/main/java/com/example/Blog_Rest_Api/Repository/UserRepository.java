package com.example.Blog_Rest_Api.Repository;

import com.example.Blog_Rest_Api.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}

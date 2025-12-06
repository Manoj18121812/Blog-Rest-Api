package com.example.Blog_Rest_Api.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.stream.events.Comment;
import java.util.List;
import java.util.Set;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String content;

    @OneToMany(mappedBy = "post" ,cascade = CascadeType.ALL)
    private List<Comment> comments;


    @ManyToMany
    @JoinTable(name ="post_likes",
    joinColumns = @JoinColumn(name="post_id"),
            inverseJoinColumns = @JoinColumn(name="user_id")
    )
    private Set<User> likedUsers;

}

# 📝 Blog REST API  
A medium-level Spring Boot REST API that supports creating blog posts, adding comments, and liking/unliking posts.  
Built with a clean layered architecture (**Controller → Service → Repository**) and easily testable using Postman.

---

## 🚀 Features

### ✅ Posts API
- Create a new blog post  
- Get all posts  
- Get a post by ID  
- Update a post  
- Delete a post  

### 💬 Comments API
- Add a comment to a post  
- Get all comments for a post  
- Update a comment  
- Delete a comment  

### ❤️ Likes API
- Like a post  
- Unlike a post  
- Get like count per post  

### 🔗 Relationships
- One-to-Many → **Post → Comments**  
- Many-to-Many → **Post ↔ Users (Likes)**  

---

## 📦 Tech Stack

| Technology | Purpose |
|-----------|----------|
| Spring Boot | Backend framework |
| Spring Web | REST API |
| Spring Data JPA | ORM |
| MySQL | Database |
| Lombok | Boilerplate reduction |
| DevTools | Auto-restart |

---

## 🔧 Spring Initializr Dependencies

When generating your Spring Boot project, select:

- **Spring Web**
- **Spring Data JPA**
- **MySQL Driver**
- **Lombok**
- **DevTools (optional)**

---

## 🗂 Project Structure

src/main/java/com/example/blogapi
│
├── controller
│ ├── PostController.java
│ ├── CommentController.java
│ └── LikeController.java
│
├── entity
│ ├── Post.java
│ ├── Comment.java
│ └── User.java
│
├── repository
│ ├── PostRepository.java
│ ├── CommentRepository.java
│ └── UserRepository.java
│
├── service
│ ├── PostService.java
│ ├── CommentService.java
│ └── LikeService.java
│
└── BlogApiApplication.java

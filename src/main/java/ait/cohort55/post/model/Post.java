package ait.cohort55.post.model;

import ait.cohort55.post.dto.AddCommentDto;
import ait.cohort55.post.dto.CommentDto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Getter
@Document(collection = "posts")
public class Post {
    @Id
    private String id;
    @Setter
    private String title;
    @Setter
    private String content;
    private String author;
    private LocalDateTime dateCreated;
    @Setter
    List<String> tags;
    private Integer likes;
    List<Comment> comments;

    public Post(String title, String content, List<String> tags,String author) {
        this.title = title;
        this.content = content;
        this.author = author;
        dateCreated = LocalDateTime.now();
        likes=0;
        this.tags = tags;
        comments = new ArrayList<>();
    }

    public Integer addLike(){
       return ++likes;
    }
    public boolean addNewComment(AddCommentDto comment,String commenter){
        Comment comment1= new Comment(comment.getMessage(), commenter);
       return comments.add(comment1);

    }

}

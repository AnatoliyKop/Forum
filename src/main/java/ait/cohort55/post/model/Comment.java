package ait.cohort55.post.model;

import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.processing.Generated;
import java.time.LocalDateTime;


@Getter
@Document(collection = "comments")
public class Comment {
    private String user;
    private  String message;
    private LocalDateTime dateCreated;
    Integer likes;


    public Comment(String message, String user) {
        this.message = message;
        this.user = user;
        dateCreated = LocalDateTime.now();
        likes = 0;
    }
    public Integer addLikes(Integer likes){

        return likes++;
    }
}

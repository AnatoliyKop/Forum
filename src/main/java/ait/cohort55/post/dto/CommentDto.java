package ait.cohort55.post.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Getter

public class CommentDto {
    private String user;
    private  String message;
    private LocalDateTime dateCreated;
    Integer likes;

}

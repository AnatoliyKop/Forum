package ait.cohort55.post.dto;

import ait.cohort55.post.model.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {

    private String id;

    private String title;
    private String content;
    private String author;
    private LocalDateTime dateCreated;
    List<String> tags;
    private Integer likes;
    List<Comment> comments;
}

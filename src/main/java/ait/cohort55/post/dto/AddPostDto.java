package ait.cohort55.post.dto;

import lombok.Getter;

import java.util.List;
@Getter
public class AddPostDto {

    private String title;
    private String content;
    List<String> tags;
}

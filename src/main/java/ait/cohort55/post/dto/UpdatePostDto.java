package ait.cohort55.post.dto;

import lombok.Getter;

import java.util.List;
@Getter
public class UpdatePostDto {
     private String title;
     List<String>tags;
     private String content;
}

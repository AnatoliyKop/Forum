package ait.cohort55.post.service;

import ait.cohort55.post.dto.AddCommentDto;
import ait.cohort55.post.dto.AddPostDto;
import ait.cohort55.post.dto.PostDto;

import java.time.LocalDate;
import java.util.List;

public interface PostService {

    PostDto addPost(AddPostDto addPostDto, String author);

    PostDto findPostById(String id);

    Integer addLike(String id);

    List<PostDto> findPostsByAuthor(String author);

    PostDto addComment(String id, AddCommentDto comment ,String commenter);

    PostDto deletePostById(String id);

    List<PostDto> findPostByTags(List<String> tags);

    List<PostDto>  findPostByPeriod(LocalDate from, LocalDate to);

    PostDto updatePost(String id, AddPostDto addPostDto);
}

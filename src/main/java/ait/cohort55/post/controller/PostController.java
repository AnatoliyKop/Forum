package ait.cohort55.post.controller;

import ait.cohort55.post.dto.AddCommentDto;
import ait.cohort55.post.dto.AddPostDto;
import ait.cohort55.post.dto.PostDto;
import ait.cohort55.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;


    @PostMapping("/forum/post/{user}")
    public PostDto addPost(@RequestBody AddPostDto addPostDto, @PathVariable("user") String author) {
        return postService.addPost(addPostDto, author);
    }

    @GetMapping("/forum/post/{postId}")
    public PostDto findPostById(@PathVariable("postId") String id) {
        return postService.findPostById(id);
    }

    @PatchMapping("/forum/post/{postId}/like")
    public Integer addLike(@PathVariable("postId") String id) {
        return postService.addLike(id);
    }

    @GetMapping("/forum/posts/author/{user}")
    public List<PostDto> findPostsByAuthor(@PathVariable("user") String author) {
        return postService.findPostsByAuthor(author);
    }

    @PatchMapping("/forum/post/{postId}/comment/{commenter}")
    public PostDto addComment(@PathVariable("postId") String id, @RequestBody AddCommentDto message, @PathVariable String commenter) {
        return postService.addComment(id, message,commenter);
    }

    @DeleteMapping("/forum/post/{postId}")
    public PostDto deletePostById(@PathVariable("postId") String id) {
        return postService.deletePostById(id);
    }

    @GetMapping("/forum/posts/tags")
    public List<PostDto> findPostByTags(@RequestParam("values")List<String> tags) {

        return postService.findPostByTags(tags);
    }

    @GetMapping("/forum/posts/period")
    public List<PostDto> findPostByPeriod(@RequestParam LocalDate dateFrom, @RequestParam LocalDate dateTo) {
        return postService.findPostByPeriod(dateFrom, dateTo);
    }

    @PatchMapping("/forum/post/{postId}")
    public PostDto updatePost(@PathVariable("postId") String id, @RequestBody AddPostDto addPostDto) {
        return postService.updatePost(id, addPostDto);
    }
}

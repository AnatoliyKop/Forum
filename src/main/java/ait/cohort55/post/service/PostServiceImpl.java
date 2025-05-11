package ait.cohort55.post.service;

import ait.cohort55.post.dao.PostRepository;
import ait.cohort55.post.dto.AddCommentDto;
import ait.cohort55.post.dto.AddPostDto;
import ait.cohort55.post.dto.PostDto;
import ait.cohort55.post.dto.exeptions.NotfoundPostDto;
import ait.cohort55.post.model.Post;
import ait.cohort55.post.utils.PostMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository repository;

    @Override
    public PostDto addPost(AddPostDto addPostDto, String author) {
        Post post = new Post(addPostDto.getTitle(), addPostDto.getContent(), addPostDto.getTags(), author);
        repository.save(post);
        return PostMapper.postToDto(post);
    }


    @Override
    public PostDto findPostById(String id) {
        Post post = repository.findById(id).orElseThrow(NotfoundPostDto::new);
        return PostMapper.postToDto(post);
    }

    @Override
    public Integer addLike(String id) {
        Post post = repository.findById(id).orElseThrow(NotfoundPostDto::new);
        post.addLike();
        repository.save(post);
        return post.getLikes();

    }

    @Override
    public List<PostDto> findPostsByAuthor(String author) {
        return repository.findAllByAuthor(author)
                .map(PostMapper::postToDto)
                .collect(Collectors.toList());

    }

    @Override
    public PostDto addComment(String id, AddCommentDto comment ,String author) {
        Post post = repository.findById(id).orElseThrow(NotfoundPostDto::new);
        post.addNewComment(comment,author);
        repository.save(post);
        return PostMapper.postToDto(post);
    }

    @Override
    public PostDto deletePostById(String id) {
        Post post = repository.findById(id).orElseThrow(NotfoundPostDto::new);
        repository.delete(post);
        return PostMapper.postToDto(post);
    }

    @Override
    public List<PostDto> findPostByTags(List<String> tags) {
        return repository
                .findAllByTagsIn(tags)
                .map(PostMapper::postToDto)
                .toList();
    }

    @Override
    public  List<PostDto>  findPostByPeriod(LocalDate from, LocalDate to) {
       return repository.findAllByDateCreatedBetween(from, to.plusDays(1))
                .map(PostMapper::postToDto)
                .toList();
    }

    @Override
    public PostDto updatePost(String id, AddPostDto addPostDto) {
        Post post=repository.findById(id).orElseThrow(NotfoundPostDto::new);
        post.setTitle(addPostDto.getTitle());
        post.setContent(addPostDto.getContent());
        post.setTags(addPostDto.getTags());
        return PostMapper.postToDto(post);
    }
}

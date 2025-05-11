package ait.cohort55.post.utils;

import ait.cohort55.post.dto.PostDto;
import ait.cohort55.post.model.Post;

public class PostMapper {
    public static PostDto postToDto(Post post){
        return new PostDto(post.getId(), post.getTitle(), post.getContent(), post.getAuthor(), post.getDateCreated(), post.getTags(), post.getLikes(), post.getComments());
    }

}

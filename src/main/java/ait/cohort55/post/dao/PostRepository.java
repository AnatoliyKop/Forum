package ait.cohort55.post.dao;

import ait.cohort55.post.model.Post;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

public interface PostRepository extends CrudRepository<Post,String> {
Stream<Post> findAllByAuthor(String author);
Stream<Post> findAllByTagsIn(List<String> tags);
Stream<Post> findAllByDateCreatedBetween(LocalDate from, LocalDate to);
}

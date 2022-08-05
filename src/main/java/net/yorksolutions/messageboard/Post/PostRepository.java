package net.yorksolutions.messageboard.Post;
import net.yorksolutions.messageboard.Post.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> { }
 //BE VERY CAREFUL WHAT YOU NAME STUFF UP THERE!!!
package net.yorksolutions.messageboard.Comment;
import net.yorksolutions.messageboard.Comment.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {
}

package net.yorksolutions.messageboard.Comment;

import net.yorksolutions.messageboard.Account.Account;
import net.yorksolutions.messageboard.Account.AccountRepository;
import net.yorksolutions.messageboard.Comment.Comment;
import net.yorksolutions.messageboard.Comment.CommentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class CommentService {

    CommentRepository commentRepository;
    AccountRepository accountRepository;

    public CommentService(CommentRepository commentRepository, AccountRepository accountRepository) {
        this.commentRepository = commentRepository;
        this.accountRepository = accountRepository;
    }

    public void createComment(String username, String password, String body) {
        Optional<Account> account = accountRepository.findByUsernameAndPassword(username, password);
        if(account.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        if(body.isEmpty() | body.isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Comment comment = new Comment(account.get(), body);
        commentRepository.save(comment);
    }
    public Iterable<Comment> getComments(String username, String password) {
        Optional<Account> account = accountRepository.findByUsernameAndPassword(username, password);
        if(account.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        return commentRepository.findAll();
    }
    //todo edit comments by comment id and author id

    //todo verify author id as deleter
    public void deleteComment(String username, String password, Long id) {
        Optional<Account> account = accountRepository.findByUsernameAndPassword(username, password);
        if(account.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        commentRepository.deleteById(id);
    }
}

package net.yorksolutions.messageboard.Post;
import net.yorksolutions.messageboard.Account.Account;
import net.yorksolutions.messageboard.Account.AccountRepository;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.Optional;

@Service
public class PostService {

    PostRepository postRepository;
    AccountRepository accountRepository;

    public PostService(PostRepository postRepository, AccountRepository accountRepository) {
        this.postRepository = postRepository;
        this.accountRepository = accountRepository;
    }

    public void createPost(String username, String password, String title, String body) {
        Optional<Account> account = accountRepository.findByUsernameAndPassword(username, password);
        if (account.isEmpty()){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        if(title.isEmpty() | title.isBlank() | body.isEmpty() | body.isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Post post = new Post(account.get(), title, body);
        postRepository.save(post);
    }
    public Iterable<Post> getPosts(String username, String password) {
        Optional<Account> account = accountRepository.findByUsernameAndPassword(username, password);
        if(account.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        return postRepository.findAll();
    }
    //todo edit post by post id and verify author
    //public void editPost() {}
    //if user id matches author id, let new body be set
    //look at reminders app


    //todo verify author id = deleter
    public void deletePost(String username, String password, Long id) {
        Optional<Account> account = accountRepository.findByUsernameAndPassword(username, password);
        if(account.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        postRepository.deleteById(id);
    }
}

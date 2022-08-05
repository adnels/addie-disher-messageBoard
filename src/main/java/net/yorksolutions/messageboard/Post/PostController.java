package net.yorksolutions.messageboard.Post;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
@CrossOrigin
public class PostController {

    PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/create")
    public void post(@RequestBody PostRequestCreate requestBody) {
        postService.createPost(requestBody.username, requestBody.password, requestBody.title, requestBody.body);
    }

    @GetMapping("/get")
    public Iterable<Post> getPosts(@RequestBody PostRequestGet requestBody) {
        return postService.getPosts(requestBody.username, requestBody.password);
    }

    @PutMapping("/edit")
    public void edit() {
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody PostRequestDelete requestBody) {
        postService.deletePost(requestBody.username, requestBody.password, requestBody.id);
    }
}

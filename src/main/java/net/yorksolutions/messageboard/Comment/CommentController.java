package net.yorksolutions.messageboard.Comment;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
@CrossOrigin
public class CommentController {

    CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/create")
    public void comment(@RequestBody CommentRequestCreate requestBody){
        commentService.createComment(requestBody.username, requestBody.password, requestBody.body);
    }

    @GetMapping("/get")
    public Iterable<Comment> getComments(@RequestBody CommentRequestGet requestBody) {
        return commentService.getComments(requestBody.username, requestBody.password);
    }
//todo edit comments
    @PutMapping("/edit")
    public void edit() {}

    @DeleteMapping("/delete")
    public void delete(@RequestBody CommentRequestDelete requestBody) {
        commentService.deleteComment(requestBody.username, requestBody.password, requestBody.id);
    }
}

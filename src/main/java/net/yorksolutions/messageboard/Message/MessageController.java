package net.yorksolutions.messageboard.Message;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/message")
@CrossOrigin
public class MessageController {

    MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/create")
    public void message(@RequestBody MessageRequest requestBody) {
        messageService.createMessage(requestBody.username, requestBody.password, requestBody.recipient, requestBody.body);
    }

    @PostMapping("/get")
    public Iterable<Message> get(@RequestBody MessageRequestGet requestBody){
        return messageService.getMessages(requestBody.username, requestBody.password);
    }
}

package net.yorksolutions.messageboard.Message;
import net.yorksolutions.messageboard.Account.Account;
import net.yorksolutions.messageboard.Account.AccountRepository;
import net.yorksolutions.messageboard.Message.Message;
import net.yorksolutions.messageboard.Message.MessageRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.Optional;

@Service
public class MessageService {

    MessageRepository messageRepository;
    AccountRepository accountRepository;

    public MessageService(MessageRepository messageRepository, AccountRepository accountRepository) {
        this.messageRepository = messageRepository;
        this.accountRepository = accountRepository;
    }
    public void createMessage(String username, String password, String recipient, String body) {
        Optional<Account> account = accountRepository.findByUsernameAndPassword(username, password);
        if(account.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        Optional<Account> recipientAccount = accountRepository.findByUsername(recipient);
        if(recipientAccount.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        if(body.isEmpty() | body.isBlank()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Message message = new Message(account.get(), recipientAccount.get(), body);
        messageRepository.save(message);
    }

          //todo display only user's messages (sent and received)
    public Iterable<Message> getMessages(String username, String password) {
       Optional<Account> accountOptional = accountRepository.findByUsernameAndPassword(username, password);
        System.out.println(username);
       if(accountOptional.isEmpty()) {
           throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
       }
       //TODO left off here
//       Iterable<Message> messageList = messageRepository.findAll();
//       if(account.get().id.equals() ) {}




       //return messageRepository.findById(account.get().id);
        //return messageRepository.findAll();
        return messageRepository.getBySenderOrRecipient(accountOptional.get(), accountOptional.get());



    }}

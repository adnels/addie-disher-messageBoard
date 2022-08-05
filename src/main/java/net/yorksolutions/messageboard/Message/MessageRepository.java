package net.yorksolutions.messageboard.Message;

import net.yorksolutions.messageboard.Account.Account;
import net.yorksolutions.messageboard.Message.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends CrudRepository<Message, Long> {
    Iterable<Message> getBySenderOrRecipient(Account accountSender, Account accountRecipient);}

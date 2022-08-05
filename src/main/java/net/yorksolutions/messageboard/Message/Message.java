package net.yorksolutions.messageboard.Message;
import com.fasterxml.jackson.annotation.JsonProperty;
import net.yorksolutions.messageboard.Account.Account;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @JsonProperty
    Long id;
    @JsonProperty
    LocalDateTime date;
    @JsonProperty
    @ManyToOne
    Account sender;

    @JsonProperty
    @ManyToOne
    Account recipient;

    @JsonProperty
    String body;

    public Message() {}

    public Message(Account account, Account recipient, String body) {
        this.sender = account;
        this.recipient = recipient;
        this.body = body;
        this.date = LocalDateTime.now();
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}

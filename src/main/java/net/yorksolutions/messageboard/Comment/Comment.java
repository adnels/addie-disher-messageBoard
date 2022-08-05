package net.yorksolutions.messageboard.Comment;
import com.fasterxml.jackson.annotation.JsonProperty;
import net.yorksolutions.messageboard.Account.Account;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @JsonProperty
    Long id;

//    @ManyToOne
//    @JsonProperty
//    Post parent;

    @JsonProperty
    LocalDateTime date;

    @ManyToOne
    @JsonProperty
    Account author;

    @JsonProperty
    String body;

    //todo add parent post relationship

    public Comment() {}

    public Comment(Account account, String body) {
        this.author = account;
        this.body = body;
        this.date = LocalDateTime.now();
    }

}

package net.yorksolutions.messageboard.Post;
import com.fasterxml.jackson.annotation.JsonProperty;
import net.yorksolutions.messageboard.Account.Account;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @JsonProperty
    Long id;

    @JsonProperty
    LocalDateTime date;

    @ManyToOne
    @JsonProperty
    Account author;

    @JsonProperty
    String title;

    @JsonProperty
    String body;

    public Post() {}

    public Post(Account account, String title, String body) {
        this.author = account;
        this.title = title;
        this.body = body;
        this.date = LocalDateTime.now();
    }
}

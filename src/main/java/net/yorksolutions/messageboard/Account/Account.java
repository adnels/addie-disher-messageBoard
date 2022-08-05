package net.yorksolutions.messageboard.Account;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @JsonProperty
    Long id;
    @JsonProperty
    String username;

//TODO this works but is bad?! :( would getter be acceptable?
    @JsonProperty
    String password;

    public Account() {}

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

}

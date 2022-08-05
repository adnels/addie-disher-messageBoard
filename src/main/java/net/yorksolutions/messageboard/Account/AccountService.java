package net.yorksolutions.messageboard.Account;
import net.yorksolutions.messageboard.Account.Account;
import net.yorksolutions.messageboard.Account.AccountRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.Optional;

@Service
public class AccountService {

    AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void createAccount(String username, String password) {
        Optional<Account> existingAccount = accountRepository.findByUsername(username);
        if (existingAccount.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        if (username.length() < 4 || password.length() < 4) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        if (username.length() > 8 || password.length() > 8) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Account account = new Account(username, password);
        accountRepository.save(account);
    }
    public Iterable<Account> getAccounts(String username, String password) {
        Optional<Account> account = accountRepository.findByUsernameAndPassword(username, password);
        if(account.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        return accountRepository.findAll();
    }
    public Account login(String username, String password) {

        Optional<Account> foundAccount = accountRepository.findByUsernameAndPassword(username, password);
        if (foundAccount.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        return foundAccount.get();
    }
}

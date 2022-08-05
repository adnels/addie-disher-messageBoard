package net.yorksolutions.messageboard.Account;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
@CrossOrigin
public class AccountController {

    AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/create")
    public void account(@RequestBody AccountRequestCreate requestBody) {
        accountService.createAccount(requestBody.username, requestBody.password);
    }

    @PostMapping ("/login")
    public Account login(@RequestBody AccountRequestLogin requestBody) {
        return accountService.login(requestBody.username, requestBody.password);
    }

    @GetMapping("/users")
    public Iterable<Account> users(@RequestBody AccountRequestGetUsers requestBody) {
        return accountService.getAccounts(requestBody.username, requestBody.password);
    }
}


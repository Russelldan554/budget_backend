package budget.api.account;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import budget.api.user.User;

@CrossOrigin(origins = "*")
@RestController
public class AccountController {
    
	@Autowired
	private AccountService accountService;
	
	@RequestMapping("/users/{userId}/accounts")
	public List<Account> getAllAccounts(@PathVariable Long userId) {
		return accountService.getAllAccounts(userId);
	}
	
	@RequestMapping("/users/{userId}/accounts/{accountId}")
	public Optional<Account> getAccount( @PathVariable Long userId, @PathVariable Long accountId) {
		return accountService.getAccount(accountId);
	}
	
	@RequestMapping(method=RequestMethod.POST, value = "/users/{userId}/accounts")
	public void addAccount(@RequestBody Account account, @PathVariable Long userId) {
		account.setUser(new User(userId, "","","","","",null));
		accountService.addAccount(account);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value = "/users/{userId}/accounts/{accountId}")
	public void updateAccount(@RequestBody Account account, @PathVariable Long userId, @PathVariable Long accountId) {
		account.setUser(new User(userId, "", "","","","",null));
		accountService.updateAccount(account);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value = "/users/{userId}/accounts/{accountId}")
	public void deleteAccount( @PathVariable Long userId, @PathVariable Long accountId) {
		accountService.deleteAccount(accountId);
	}
}

/*
 * File: AccountController.java
 * Author: Team Moolah, UMUC CMSC495 7980
 * Date: Spring 2019
 * Description: This is the class maps URL requests JSON data to the appropriate account service and generates JSON responses
 */

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
import budget.api.ResourceNotFoundException;
import budget.api.user.User;

@CrossOrigin(origins = "*") // allow cross origin from any domain
@RestController // annotate this class as a Spring RESTful api controller
public class AccountController {

	// declare local variables
	@Autowired
	private AccountService accountService;

	// This method maps Get requests to accountService.getAllAccounts().
	@RequestMapping("/users/{userId}/accounts")
	public List<Account> getAllAccounts(@PathVariable Long userId) {
		List<Account> accountList = accountService.getAllAccounts(userId);
		return accountList;
	}// end method getAllAccounts

	// This method maps Get requests to accountService.getAccount(id).
	@RequestMapping("/users/{userId}/accounts/{accountId}")
	public Optional<Account> getAccount(@PathVariable Long userId, @PathVariable Long accountId) {
		Optional<Account> account = accountService.getAccount(accountId);
		if (!account.isPresent()) {
			throw new ResourceNotFoundException("Account not found.");// thrown is user doen't exist in database
		}
		return account;
	}// end method getAccount

	// This method maps Post requests to accountService.addAccount(account). It also
	// sets the User object for this account.
	@RequestMapping(method = RequestMethod.POST, value = "/users/{userId}/accounts")
	public void addAccount(@RequestBody Account account, @PathVariable Long userId) {
		account.setUser(new User(userId, "", "", "", "", "", null));
		accountService.addAccount(account);
	}// end method addAccount

	// This method maps Put requests to accountService.updateAccount(id, account).
	// It also sets the User object for this account.
	@RequestMapping(method = RequestMethod.PUT, value = "/users/{userId}/accounts/{accountId}")
	public void updateAccount(@RequestBody Account account, @PathVariable Long userId, @PathVariable Long accountId) {
		account.setUser(new User(userId, "", "", "", "", "", null));
		accountService.updateAccount(account);
	}// end method updateAccount

	// This method maps Delete requests to accountService.deleteAccount(id)
	@RequestMapping(method = RequestMethod.DELETE, value = "/users/{userId}/accounts/{accountId}")
	public void deleteAccount(@PathVariable Long userId, @PathVariable Long accountId) {
		accountService.deleteAccount(accountId);
	}// end method deleteAccount
}// end class AccountController

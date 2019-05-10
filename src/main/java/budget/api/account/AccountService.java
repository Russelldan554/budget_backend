/*
 * File: AccountService.java
 * Author: Team Moolah, UMUC CMSC495 7980
 * Date: Spring 2019
 * Description: This is the class contains the methods which manipulate accounts in the account repository
 */

package budget.api.account;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // annotate this class as a Spring service
public class AccountService {

	// declare local variables
	@Autowired
	private AccountRepository accountRepository;

	// This method returns a list of all accounts with specific userId from the
	// accountRepository.
	public List<Account> getAllAccounts(Long userId) {
		List<Account> accounts = new ArrayList<>();
		accountRepository.findByUserUserId(userId).forEach(accounts::add);
		return accounts;
	}// end method getAllAccounts

	// This method returns a specific account by accountId from the
	// accountRepository.
	public Optional<Account> getAccount(Long accountId) {
		return accountRepository.findById(accountId);
	}// end method getAccount

	// This method saves an account to the accountRepository.
	public void addAccount(Account account) {
		accountRepository.save(account);
	}// end method addAccount

	// This method replaces the account in accountRepository, with account
	// passed-in.
	public void updateAccount(Account account) {
		accountRepository.save(account);
	}// end method updateAccount

	// This method deletes the account in accountRepository.
	public void deleteAccount(Long accountId) {
		accountRepository.deleteById(accountId);
	}// end method deleteAccount
}// end class AccountService

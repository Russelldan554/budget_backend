package budget.api.account;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

	@Autowired
	private AccountRepository accountRepository;

	public List<Account> getAllAccounts(Long userId) {
		List<Account> accounts = new ArrayList<>();
		accountRepository.findByUserUserId(userId).forEach(accounts::add);
		return accounts;
	}

	public Optional<Account> getAccount(Long accountId) {
		return accountRepository.findById(accountId);
	}

	public void addAccount(Account account) {
		accountRepository.save(account);
	}

	public void updateAccount(Account account) {
		accountRepository.save(account);
	}

	public void deleteAccount(Long accountId) {
		accountRepository.deleteById(accountId);
	}
}

package budget.api.account;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Service;
import budget.api.ResourceNotFoundException;

@Service
public class AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@PostAuthorize("returnObject.get(0).user.userName == authentication.name")
	public List<Account> getAllAccounts(Long userId) {
		List<Account> accounts = new ArrayList<>();
		accountRepository.findByUserUserId(userId).forEach(accounts::add);
		return accounts;
	}

	@PostAuthorize("returnObject.user.userName == authentication.name")
	public Account getAccount(Long accountId) {
		Optional<Account> optAccount = accountRepository.findById(accountId);
		if (!optAccount.isPresent()) {
			throw new ResourceNotFoundException("Account not found.");
		}
		return optAccount.get();
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

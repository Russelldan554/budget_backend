package budget.api.transaction;

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
import budget.api.account.Account;

@CrossOrigin(origins = "*")
@RestController
public class TransactionController {

	@Autowired
	private TransactionService transactionService;

	@RequestMapping("/users/{userId}/accounts/{accountId}/transactions")
	public List<Transaction> getAllTransactions(@PathVariable Long userId, @PathVariable Long accountId) {
		List<Transaction> transactionList = transactionService.getAllTransactions(accountId);
		if (transactionList.size() < 1) {
			throw new NullPointerException("No transactions found.");
		}
		return transactionList;
	}

	@RequestMapping("/users/{userId}/accounts/{accountId}/transactions/{transactionId}")
	public Optional<Transaction> getTransaction(@PathVariable Long userId, @PathVariable Long accountId,
			@PathVariable Long transactionId) {
		Optional<Transaction> transaction = transactionService.getTransaction(transactionId);
		if (!transaction.isPresent()) {
			throw new ResourceNotFoundException("Transaction not found.");
		}
		return transaction;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/users/{userId}/accounts/{accountId}/transactions")
	public void addTransaction(@RequestBody Transaction transaction, @PathVariable Long userId,
			@PathVariable Long accountId) {
		transaction.setAccount(new Account(accountId, "", null, null));
		transactionService.addTransaction(transaction);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/users/{userId}/accounts/{accountId}/transactions/{transactionId}")
	public void updateTransaction(@RequestBody Transaction transaction, @PathVariable Long userId,
			@PathVariable Long accountId, @PathVariable Long transactionId) {
		transaction.setAccount(new Account(accountId, "", null, null));
		transactionService.updateTransaction(transaction);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/users/{userId}/accounts/{accountId}/transactions/{transactionId}")
	public void deleteTransaction(@PathVariable Long userId, @PathVariable Long accountId,
			@PathVariable Long transactionId) {
		transactionService.deleteTransaction(transactionId);
	}
}

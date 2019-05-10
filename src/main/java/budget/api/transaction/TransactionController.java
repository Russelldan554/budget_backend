/*
 * File: TransactionController.java
 * Author: Team Moolah, UMUC CMSC495 7980
 * Date: Spring 2019
 * Description: This is the class maps URL requests JSON data to the appropriate transaction service and generates JSON responses
 */

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

@CrossOrigin(origins = "*") // allow cross origin from any domain
@RestController // annotate this class as a Spring RESTful api controller
public class TransactionController {

	// declare local variables
	@Autowired
	private TransactionService transactionService;

	// This method maps Get requests to transactionService.getAllTransactions().
	@RequestMapping("/users/{userId}/accounts/{accountId}/transactions")
	public List<Transaction> getAllTransactions(@PathVariable Long userId, @PathVariable Long accountId) {
		List<Transaction> transactionList = transactionService.getAllTransactions(accountId);
		if (transactionList.size() < 1) {
			throw new NullPointerException("No transactions found.");
		}
		return transactionList;
	}// end method getAllTransactions

	// This method maps Get requests to transactionService.getTransaction(id).
	@RequestMapping("/users/{userId}/transactions")
	public List<Transaction> getAllTransactionsByUserId(@PathVariable Long userId) {
		List<Transaction> transactionList = transactionService.getAllTransactionsByUserId(userId);
		if (transactionList.size() < 1) {
			throw new NullPointerException("No transactions found.");
		}
		return transactionList;
	}// end method getAllTransactionsByUserId

	// This method maps Post requests to
	// transactionService.addTransaction(transaction).
	@RequestMapping("/users/{userId}/accounts/{accountId}/transactions/{transactionId}")
	public Optional<Transaction> getTransaction(@PathVariable Long userId, @PathVariable Long accountId,
			@PathVariable Long transactionId) {
		Optional<Transaction> transaction = transactionService.getTransaction(transactionId);
		if (!transaction.isPresent()) {
			throw new ResourceNotFoundException("Transaction not found.");
		}
		return transaction;
	}// end method getTransaction

	// This method maps Post requests to
	// transactionService.addTransaction(transaction). It also sets the User object
	// for this transaction.
	@RequestMapping(method = RequestMethod.POST, value = "/users/{userId}/accounts/{accountId}/transactions")
	public void addTransaction(@RequestBody Transaction transaction, @PathVariable Long userId,
			@PathVariable Long accountId) {
		transaction.setAccount(new Account(accountId, "", "", "", null, null));
		transaction.setUserId(userId);
		transactionService.addTransaction(transaction);
	}// end method addTransaction

	// This method maps Put requests to transactionService.updateTransaction(id,
	// transaction). It also sets the User object for this transaction.
	@RequestMapping(method = RequestMethod.PUT, value = "/users/{userId}/accounts/{accountId}/transactions/{transactionId}")
	public void updateTransaction(@RequestBody Transaction transaction, @PathVariable Long userId,
			@PathVariable Long accountId, @PathVariable Long transactionId) {
		transaction.setAccount(new Account(accountId, "", "", "", null, null));
		transaction.setUserId(userId);
		transactionService.updateTransaction(transaction);
	}// end method updateTransaction

	// This method maps Delete requests to transactionService.deleteTransaction(id)
	@RequestMapping(method = RequestMethod.DELETE, value = "/users/{userId}/accounts/{accountId}/transactions/{transactionId}")
	public void deleteTransaction(@PathVariable Long userId, @PathVariable Long accountId,
			@PathVariable Long transactionId) {
		transactionService.deleteTransaction(transactionId);
	}// end method deleteTransaction
}// end class TransactionController

/*
 * File: TransactionService.java
 * Author: Team Moolah, UMUC CMSC495 7980
 * Date: Spring 2019
 * Description: This is the class contains the methods which manipulate transactions in the transaction repository
 */

package budget.api.transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // annotate this class as a Spring service
public class TransactionService {

	// declare local variables
	@Autowired
	private TransactionRepository transactionRepository;

	// This method returns a list of all transactions with specific accountId from
	// the transactionRepository.
	public List<Transaction> getAllTransactions(Long accountId) {
		List<Transaction> transactions = new ArrayList<>();
		transactionRepository.findByAccountAccountId(accountId).forEach(transactions::add);
		return transactions;
	}// end method getAllTransactions

	// This method returns a list of all transactions with specific userId from the
	// transactionRepository.
	public List<Transaction> getAllTransactionsByUserId(Long userId) {
		List<Transaction> transactions = new ArrayList<>();
		transactionRepository.findByuserId(userId).forEach(transactions::add);
		return transactions;
	}// end method getAllTransactionsByUserId

	// This method returns a specific transaction by transactionId from the
	// transactionRepository.
	public Optional<Transaction> getTransaction(Long transactionId) {
		return transactionRepository.findById(transactionId);
	}// end method getTransaction

	// This method saves a transaction to the transactionRepository.
	public void addTransaction(Transaction transaction) {
		transactionRepository.save(transaction);
	}// end method addTransaction

	// This method replaces the transaction in transactionRepository, with
	// transaction passed-in.
	public void updateTransaction(Transaction transaction) {
		transactionRepository.save(transaction);
	}// end method updateTransaction

	// This method deletes the transaction in transactionRepository.
	public void deleteTransaction(Long transactionId) {
		transactionRepository.deleteById(transactionId);
	}// end method deleteTransaction
}// end class TransactionService

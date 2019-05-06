package budget.api.transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Service;

import budget.api.ResourceNotFoundException;

@Service
public class TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;

	public List<Transaction> getAllTransactions(Long accountId) {
		List<Transaction> transactions = new ArrayList<>();
		transactionRepository.findByAccountAccountId(accountId).forEach(transactions::add);
		return transactions;
	}

	public List<Transaction> getAllTransactionsByUserId(Long userId) {
		List<Transaction> transactions = new ArrayList<>();
		transactionRepository.findByuserId(userId).forEach(transactions::add);
		return transactions;
	}

	public Transaction getTransaction(Long transactionId) {
		Optional<Transaction> optTransaction = transactionRepository.findById(transactionId);
		if (!optTransaction.isPresent()) {
			throw new ResourceNotFoundException("Transaction not found.");
		}
		return optTransaction.get();
	}

	public void addTransaction(Transaction transaction) {
		transactionRepository.save(transaction);
	}

	public void updateTransaction(Transaction transaction) {
		transactionRepository.save(transaction);
	}

	public void deleteTransaction(Long transactionId) {
		transactionRepository.deleteById(transactionId);
	}
}

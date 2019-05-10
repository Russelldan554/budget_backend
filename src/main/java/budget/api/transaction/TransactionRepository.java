/*
 * File: TransactionRepository.java
 * Author: Team Moolah, UMUC CMSC495 7980
 * Date: Spring 2019
 * Description: This is the class manipulates transactions in the database
 */

package budget.api.transaction;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {

	// method from Transaction repository that retrieves List of transactions for a
	// specific account accountId
	public List<Transaction> findByAccountAccountId(Long accountId);

	// method from Transaction repository that retrieves List of transactions for a
	// specific userId
	public List<Transaction> findByuserId(Long userId);
}// end interface TransactionRepository

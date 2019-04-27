package budget.api.transaction;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {

	public List<Transaction> findByAccountAccountId(Long accountId);
	
	public List<Transaction> findByuserId(Long userId);

}

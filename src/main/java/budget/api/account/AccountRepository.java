package budget.api.account;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long> {

	public List<Account> findByUserUserId(Long userId);

}

/*
 * File: AccountRepository.java
 * Author: Team Moolah, UMUC CMSC495 7980
 * Date: Spring 2019
 * Description: This is the class manipulates accounts in the database
 */

package budget.api.account;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long> {

	// method from Account repository that retrieves List of accounts for a specific
	// user userId
	public List<Account> findByUserUserId(Long userId);
}// end interface AccountRepository

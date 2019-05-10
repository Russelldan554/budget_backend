/*
 * File: BudgetRepository.java
 * Author: Team Moolah, UMUC CMSC495 7980
 * Date: Spring 2019
 * Description: This is the class manipulates budgets in the database
 */

package budget.api.budget;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface BudgetRepository extends CrudRepository<Budget, Long> {

	// method from Budget repository that retrieves List of budgets for a specific
	// user userId
	public List<Budget> findByUserUserId(Long userId);
}// end interface BudgetRepository

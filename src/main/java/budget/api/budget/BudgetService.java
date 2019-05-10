/*
 * File: BudgetService.java
 * Author: Team Moolah, UMUC CMSC495 7980
 * Date: Spring 2019
 * Description: This is the class contains the methods which manipulate budgets in the budget repository
 */

package budget.api.budget;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // annotate this class as a Spring service
public class BudgetService {

	//declare local variables
	@Autowired
	private BudgetRepository budgetRepository;

	//This method returns a list of all budgets with specific userId from the budgetRepository.
	public List<Budget> getAllBudgets(Long userId) {
		List<Budget> budgets = new ArrayList<>();
		budgetRepository.findByUserUserId(userId).forEach(budgets::add);
		return budgets;
	}//end method getAllBudgets

	//This method returns a specific budget by budgetId from the budgetRepository.
	public Optional<Budget> getBudget(Long budgetId) {
		return budgetRepository.findById(budgetId);
	}//end method getBudget

	//This method saves a budget to the budgetRepository.
	public void addBudget(Budget budget) {
		budgetRepository.save(budget);
	}//end method addBudget

	//This method replaces the budget in budgetRepository, with budget passed-in.
	public void updateBudget(Budget budget) {
		budgetRepository.save(budget);
	}//end method updateBudget

	//This method deletes the budget in budgetRepository.
	public void deleteBudget(Long budgetId) {
		budgetRepository.deleteById(budgetId);
	}//end method deleteBudget
}//end class BudgetService

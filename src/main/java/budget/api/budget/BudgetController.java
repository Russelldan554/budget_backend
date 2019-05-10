/*
 * File: BudgetController.java
 * Author: Team Moolah, UMUC CMSC495 7980
 * Date: Spring 2019
 * Description: This is the class maps URL requests JSON data to the appropriate budget service and generates JSON responses
 */

package budget.api.budget;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import budget.api.user.User;

@CrossOrigin(origins = "*") // allow cross origin from any domain
@RestController // annotate this class as a Spring RESTful api controller
public class BudgetController {

	// declare local variables
	@Autowired
	private BudgetService budgetService;

	// This method maps Get requests to budgetService.getAllBudgets().
	@RequestMapping("/users/{userId}/budgets")
	public List<Budget> getAllBudgets(@PathVariable Long userId) {
		return budgetService.getAllBudgets(userId);
	}// end method getAllBudgets

	// This method maps Get requests to budgetService.getBudget(id).
	@RequestMapping("/users/{userId}/budgets/{budgetId}")
	public Optional<Budget> getBudget(@PathVariable Long userId, @PathVariable Long budgetId) {
		return budgetService.getBudget(budgetId);
	}// end method getBudget

	// This method maps Post requests to budgetService.addBudget(budget).
	@RequestMapping(method = RequestMethod.POST, value = "/users/{userId}/budgets")
	public void addBudget(@RequestBody Budget budget, @PathVariable Long userId) {
		budget.setUser(new User(userId, "", "", "", "", "", null));
		budgetService.addBudget(budget);
	}// end method addBudget

	// This method maps Put requests to budgetService.updateBudget(id, budget). It
	// also sets the User object for this budget.
	@RequestMapping(method = RequestMethod.PUT, value = "/users/{userId}/budgets/{budgetId}")
	public void updateBudget(@RequestBody Budget budget, @PathVariable Long userId, @PathVariable Long budgetId) {
		budget.setUser(new User(userId, "", "", "", "", "", null));
		budgetService.updateBudget(budget);
	}// end method updateBudget

	// This method maps Delete requests to budgetService.deleteBudget(id)
	@RequestMapping(method = RequestMethod.DELETE, value = "/users/{userId}/budgets/{budgetId}")
	public void deleteBudget(@PathVariable Long userId, @PathVariable Long budgetId) {
		budgetService.deleteBudget(budgetId);
	}// end method deleteBudget
}// end class BudgetController

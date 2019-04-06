package budget.api.budget;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import budget.api.user.User;

@RestController
public class BudgetController {
    
	@Autowired
	private BudgetService budgetService;
	
	@RequestMapping("/users/{userId}/budgets")
	public List<Budget> getAllBudgets(@PathVariable Long userId) {
		return budgetService.getAllBudgets(userId);
	}
	
	@RequestMapping("/users/{userId}/budgets/{budgetId}")
	public Optional<Budget> getBudget( @PathVariable Long userId, @PathVariable Long budgetId) {
		return budgetService.getBudget(budgetId);
	}
	
	@RequestMapping(method=RequestMethod.POST, value = "/users/{userId}/budgets")
	public void addBudget(@RequestBody Budget budget, @PathVariable Long userId) {
		budget.setUser(new User(userId, "","","","","",null));
		budgetService.addBudget(budget);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value = "/users/{userId}/budgets/{budgetId}")
	public void updateBudget(@RequestBody Budget budget, @PathVariable Long userId, @PathVariable Long budgetId) {
		budget.setUser(new User(userId, "", "","","","",null));
		budgetService.updateBudget(budget);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value = "/users/{userId}/budgets/{budgetId}")
	public void deleteBudget( @PathVariable Long userId, @PathVariable Long budgetId) {
		budgetService.deleteBudget(budgetId);
	}
}

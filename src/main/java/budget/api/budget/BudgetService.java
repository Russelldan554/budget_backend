package budget.api.budget;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BudgetService {

	@Autowired
	private BudgetRepository budgetRepository;

	public List<Budget> getAllBudgets(Long userId) {
		List<Budget> budgets = new ArrayList<>();
		budgetRepository.findByUserUserId(userId).forEach(budgets::add);
		return budgets;
	}

	public Optional<Budget> getBudget(Long budgetId) {
		return budgetRepository.findById(budgetId);
	}

	public void addBudget(Budget budget) {
		budgetRepository.save(budget);
	}

	public void updateBudget(Budget budget) {
		budgetRepository.save(budget);
	}

	public void deleteBudget(Long budgetId) {
		budgetRepository.deleteById(budgetId);
	}
}

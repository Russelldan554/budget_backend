package budget.api.budget;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface BudgetRepository extends CrudRepository<Budget, Long> {

	public List<Budget> findByUserUserId(Long userId);
   	
}

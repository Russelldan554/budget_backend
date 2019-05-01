package budget.api.category;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {

	public List<Category> findByUserUserId(Long userId);
	
	public List<Category> findByname(String name);
}

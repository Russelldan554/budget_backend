/*
 * File: CategoryRepository.java
 * Author: Team Moolah, UMUC CMSC495 7980
 * Date: Spring 2019
 * Description: This is the class manipulates categories in the database
 */

package budget.api.category;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {

	// method from Category repository that retrieves List of categories for a
	// specific user userId
	public List<Category> findByUserUserId(Long userId);

	// method from Category repository that retrieves List of categories containing
	// a specific name
	public List<Category> findByname(String name);
}// end interface CategoryRepository

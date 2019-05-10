/*
 * File: CategoryService.java
 * Author: Team Moolah, UMUC CMSC495 7980
 * Date: Spring 2019
 * Description: This is the class contains the methods which manipulate categories in the category repository
 */

package budget.api.category;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // annotate this class as a Spring service
public class CategoryService {

	// declare local variables
	@Autowired
	private CategoryRepository categoryRepository;

	// This method returns a list of all categories with specific userId from the
	// categoryRepository.
	public List<Category> getAllCategories(Long userId) {
		List<Category> categories = new ArrayList<>();
		categoryRepository.findByUserUserId(userId).forEach(categories::add);
		return categories;
	}// end method getAllCategories

	// This method returns a specific category by categoryId from the
	// categoryRepository.
	public Optional<Category> getCategory(Long categoryId) {
		return categoryRepository.findById(categoryId);
	}// end method getCategory

	// This method saves a category to the categoryRepository.
	public void addCategory(Category category) {
		categoryRepository.save(category);
	}// end method addCategory

	// This method replaces the category in categoryRepository, with category
	// passed-in.
	public void updateCategory(Category category) {
		categoryRepository.save(category);
	}// end method updateCategory

	// This method deletes the category in categoryRepository.
	public void deleteCategory(Long categoryId) {
		categoryRepository.deleteById(categoryId);
	}// end method deleteCategory
}// end class CategoryService

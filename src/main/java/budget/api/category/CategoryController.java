/*
 * File: CategoryController.java
 * Author: Team Moolah, UMUC CMSC495 7980
 * Date: Spring 2019
 * Description: This is the class maps URL requests JSON data to the appropriate category service and generates JSON responses
 */

package budget.api.category;

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
public class CategoryController {

	// declare local variables
	@Autowired
	private CategoryService categoryService;

	// This method maps Get requests to categoryService.getAllCategories().
	@RequestMapping("/users/{userId}/categories")
	public List<Category> getAllCategories(@PathVariable Long userId) {
		return categoryService.getAllCategories(userId);
	}// end method getAllCategories

	// This method maps Get requests to categoryService.getCategory(id).
	@RequestMapping("/users/{userId}/categories/{categoryId}")
	public Optional<Category> getCategory(@PathVariable Long userId, @PathVariable Long categoryId) {
		return categoryService.getCategory(categoryId);
	}// end method getCategory

	// This method maps Post requests to categoryService.addCategory(category). It
	// also sets the User object for this category.
	@RequestMapping(method = RequestMethod.POST, value = "/users/{userId}/categories")
	public void addCategory(@RequestBody Category category, @PathVariable Long userId) {
		category.setUser(new User(userId, "", "", "", "", "", null));
		categoryService.addCategory(category);
	}// end method addCategory

	// This method maps Put requests to categoryService.updateCategory(id,
	// category). It also sets the User object for this category.
	@RequestMapping(method = RequestMethod.PUT, value = "/users/{userId}/categories/{categoryId}")
	public void updateCategory(@RequestBody Category category, @PathVariable Long userId,
			@PathVariable Long categoryId) {
		category.setUser(new User(userId, "", "", "", "", "", null));
		categoryService.updateCategory(category);
	}// end method updateCategory

	// This method maps Delete requests to categoryService.deleteCategory(id)
	@RequestMapping(method = RequestMethod.DELETE, value = "/users/{userId}/categories/{categoryId}")
	public void deleteCategory(@PathVariable Long userId, @PathVariable Long categoryId) {
		categoryService.deleteCategory(categoryId);
	}// end method deleteCategory
}// end class CategoryController

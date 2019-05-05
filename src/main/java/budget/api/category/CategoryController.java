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

@CrossOrigin(origins = "*")
@RestController
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@RequestMapping("/users/{userId}/categories")
	public List<Category> getAllCategories(@PathVariable Long userId) {
		return categoryService.getAllCategories(userId);
	}

	@RequestMapping("/users/{userId}/categories/{categoryId}")
	public Optional<Category> getCategory(@PathVariable Long userId, @PathVariable Long categoryId) {
		return categoryService.getCategory(categoryId);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/users/{userId}/categories")
	public void addCategory(@RequestBody Category category, @PathVariable Long userId) {
		category.setUser(new User(userId, "", "", "", "", "", null));
		categoryService.addCategory(category);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/users/{userId}/categories/{categoryId}")
	public void updateCategory(@RequestBody Category category, @PathVariable Long userId, @PathVariable Long categoryId) {
		category.setUser(new User(userId, "", "", "", "", "", null));
		categoryService.updateCategory(category);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/users/{userId}/categories/{categoryId}")
	public void deleteCategory(@PathVariable Long userId, @PathVariable Long categoryId) {
		categoryService.deleteCategory(categoryId);
	}
}

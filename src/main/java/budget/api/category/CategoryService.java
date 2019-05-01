package budget.api.category;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	public List<Category> getAllCategories(Long userId) {
		List<Category> categories = new ArrayList<>();
		categoryRepository.findByUserUserId(userId).forEach(categories::add);
		return categories;
	}

	public Optional<Category> getCategory(Long categoryId) {
		return categoryRepository.findById(categoryId);
	}

	public void addCategory(Category category) {
		categoryRepository.save(category);
	}

	public void updateCategory(Category category) {
		categoryRepository.save(category);
	}

	public void deleteCategory(Long categoryId) {
		categoryRepository.deleteById(categoryId);
	}
}

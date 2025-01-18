package e_commerce.services;

import java.util.List;

import org.springframework.stereotype.Service;

import e_commerce.entities.Category;
import e_commerce.repositories.CategoryRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CategoryService {

	CategoryRepository categoryRepository;

	public Category createCategory(Category category) {
		return categoryRepository.save(category);
	}

	public List<Category> findAllCategories() {
		return categoryRepository.findAll();
	}

	public Category findCategoryById(Long categoryId) {
		var entity = categoryRepository.findById(categoryId)
				.orElseThrow(() -> new RuntimeException("Category not Found"));
		
		return entity; 
	}
	
}

package e_commerce.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import e_commerce.entities.Category;
import e_commerce.services.CategoryService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/categories")
public class CategoryController {

	CategoryService categoryService;
	
	@PostMapping
	public Category createCategory( @RequestBody Category category ){
		return categoryService.createCategory(category);
	}
	
	@GetMapping
	public List<Category> listCategories (){
		return categoryService.findAllCategories();
	}
	
}

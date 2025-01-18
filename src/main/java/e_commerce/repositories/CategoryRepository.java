package e_commerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import e_commerce.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

	void findCategoryById(Long categoryId);

}
